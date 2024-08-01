package harme.music.service;

import harme.global.client.RestClientConfig;
import harme.music.dto.*;
import harme.music.entity.MusicEntity;
import harme.music.repository.MusicsRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MusicService {
    private final OpenAiChatModel openAiChatModel;
    private final RestClientConfig restClient;
    private final MusicsRepository musicRepository;

    final String ENTER = "\n";

    @Value("${client.musicUrl}")
    String musicUrl;

    public MusicResponseDto create(MusicRequestDto musicRequestDto) {
        log.info("text = {}", musicRequestDto.concatString());

        String keyword = generateKeywords(musicRequestDto.concatString());
        log.info("keyword = {}", keyword);

        String lyrics = generateLyrics(keyword);
        log.info("lyrics = {}", lyrics);

        String title = generateTitle(keyword, lyrics);
        log.info("title = {}", title);

        StringBuffer enKeywords = new StringBuffer();
        enKeywords.append("Korean, ").append(vaild(translate(keyword))).append(", Good Quality");

        String enTitle = translate(title);

        MusicGenerateResponseDto generateMusic = generateMusic(lyrics, enTitle, enKeywords.toString())[0];

        musicRepository.save(MusicEntity.builder()
                .userId(Long.valueOf(musicRequestDto.getUserId()))
                .musicName(generateMusic.getId())
                .musicTitle(title)
                .musicLyrics(lyrics)
                .musicUrl(generateMusic.getAudio_url())
                .musicCreatedAt(LocalDateTime.now())
                .build());


        return MusicResponseDto.builder()
                .musicId(generateMusic.getId())
                .lyrics(lyrics)
                .keyword(keyword)
                .build();
    }

    private MusicGenerateResponseDto[] generateMusic(String lyrics, String enTitle, String keyword) {
        return restClient.musicClient().post().uri(musicUrl)
                .body(MusicGenerateRequestDto
                        .builder()
                        .prompt(lyrics)
                        .tags(keyword)
                        .title(enTitle)
                        .model("chirp-v3.5")
                        .make_instrumental("false")
                        .wait_audio("true")
                        .build()
                ).retrieve().body(MusicGenerateResponseDto[].class);
    }

    private String vaild(String translate) {
        if (translate.contains("trot")) {
            translate = "trot, Korean trot";
        }
        return translate;
    }

    private String generateTitle(String keyword, String lyrics) {
        StringBuffer title = new StringBuffer();
        title.append("너는 노래 제목을 지을 거야. 사용자가 제공한 노래 가사와 스타일을 기반으로 적합한 제목을 만들어줘.\n")
                .append(ENTER)
                .append("    노래의 스타일: ").append(keyword).append(ENTER).append(ENTER)
                .append("    노래 가사:").append(ENTER).append(lyrics).append(ENTER).append(ENTER)
                .append(
                        "    예시:\n" +
                                "    스타일: 발라드\n" +
                                "    가사:\n" +
                                "    어느 날 거울 앞에 서서 봤어\n" +
                                "    내 모습이 마음에 들지 않아\n" +
                                "    언제부터인가 난 힘없이 웃음 짓고\n" +
                                "    꽤나 힘든 하루를 보낼 때가 많았어\n" +
                                ENTER +
                                "    매일 변하는 유행에 쫓기며\n" +
                                "    바쁘게 웃으면서도 가면을 써\n" +
                                "    하지만 진정한 나를 찾아가는 여정에서\n" +
                                "    내 안의 꽃들이 피기 시작했어\n" +
                                ENTER +
                                "    내가 꽤나 예쁜 여자가 되어가는 중\n" +
                                "    매일 조금씩 변해가는 거잖아\n" +
                                "    내 안의 빛을 찾아 걸어가는 중\n" +
                                "    섬세한 나만의 모습을 발견하고 있어\n" +
                                ENTER +
                                "    제목: 내 안의 빛\n" +
                                ENTER +
                                "    이 정보를 바탕으로, 주어진 노래 가사와 스타일에 맞는 적합한 한국어 노래 제목을 10글자 미만으로 지어줘.\n"
                );
        return openAiChatModel.call(title.toString());
    }

    public String generateKeywords(String text) {
        StringBuffer keyword = new StringBuffer();

        keyword.append("The user has provided a text describing a song style. Extract the main keywords from this text that summarize its core elements.\nKeywords are a single word(noun) and less than six.")
                .append(ENTER).append(ENTER)
                .append("Example:")
                .append(ENTER)
                .append("    Text: 트로트 남자로 해줘 나는 활기찬 사랑 노래 만들고 싶어요.")
                .append(ENTER)
                .append("    Keywords: 남자,트로트,활기찬,사랑")
                .append(ENTER).append(ENTER)
                .append("    Text: ").append(text)
                .append(ENTER)
                .append("    Keywords: ");
        return openAiChatModel.call(keyword.toString());
    }


    public String generateLyrics(String keyword) {
        StringBuffer lyrics = new StringBuffer();

        lyrics.append("너는 노래 가사를 작성할 거야. 노래의 장르와 스타일은 다음과 같아:" + ENTER +
                        "장르와 스타일: ")
                .append(keyword)
                .append(ENTER)
                .append(ENTER +
                        "    예시:\n" +
                        "    Verse 1:\n" +
                        "    어느 날 거울 앞에 서서 봤어\n" +
                        "    내 모습이 마음에 들지 않아\n" +
                        "    언제부터인가 난 힘없이 웃음 짓고\n" +
                        "    꽤나 힘든 하루를 보낼 때가 많았어\n")
                .append(ENTER +
                        "    Verse 2:\n" +
                        "    매일 변하는 유행에 쫓기며\n" +
                        "    바쁘게 웃으면서도 가면을 써\n" +
                        "    하지만 진정한 나를 찾아가는 여정에서\n" +
                        "    내 안의 꽃들이 피기 시작했어\n")
                .append(ENTER +
                        "    Chorus:\n" +
                        "    내가 꽤나 예쁜 여자가 되어가는 중\n" +
                        "    매일 조금씩 변해가는 거잖아\n" +
                        "    내 안의 빛을 찾아 걸어가는 중\n" +
                        "    섬세한 나만의 모습을 발견하고 있어\n")
                .append(ENTER +
                        "    Verse 1:\n" +
                        "    사람들의 시선이 어지러울 때\n" +
                        "    내 안의 소리에 귀 기울이며\n" +
                        "    지금껏 보여줄 수 없었던 나의 자신을\n" +
                        "    천천히 발견해 나가는 중인 거야\n")
                .append(ENTER +
                        "    Verse 2:\n" +
                        "    너무 급하게 변하려 하지 않아\n" +
                        "    차분히 성장하는 여자로\n" +
                        "    마침내 믿음을 지녔을 때\n" +
                        "    진짜로 내가 원하는 나로 다가갈 거야\n")
                .append(ENTER +
                        "    Chorus:\n" +
                        "    내가 꽤나 예쁜 여자가 되어가는 중\n" +
                        "    매일 조금씩 변해가는 거잖아\n" +
                        "    내 안의 빛을 찾아 걸어가는 중\n" +
                        "    섬세한 나만의 모습을 발견하고 있어\n")
                .append(ENTER +
                        "    Bridge:\n" +
                        "    가끔은 힘들 수 있으나 포기하지 않을 거야\n" +
                        "    내가 원하는 그 순간을 위해\n")
                .append(ENTER +
                        "    Chorus:\n" +
                        "    내가 꽤나 예쁜 여자가 되어가는 중\n" +
                        "    매일 조금씩 변해가는 거잖아\n" +
                        "    내 안의 빛을 찾아 걸어가는 중\n" +
                        "    섬세한 나만의 모습을 발견하고 있어\n" +
                        "    내 마음 모두 너에게 줄게\n")
                .append(ENTER +
                        "    이 정보를 바탕으로, ")
                .append(keyword)
                .append(" 스타일에 맞는 한국어 노래 가사를 작성해줘. 장르에 유의해줘. 노래 가사는 다음과 같은 구조를 가질 수 있어.:\n")
                .append(ENTER +
                        "    노래가 락또는 팝이면:\n" +
                        "    - (Verse 1)\n" +
                        "    - (Chorus)\n" +
                        "    - (Verse 2)\n" +
                        "    - (Chorus)\n" +
                        "    - (Bridge) (선택 사항)\n" +
                        "    - (Chorus)\n")
                .append(ENTER +
                        "    노래가 트로트이면:\n" +
                        "    -(Intro)\n" +
                        "    -(Verse 1)\n" +
                        "    -(Chorus)\n" +
                        "    -(Verse 2)\n" +
                        "    -(Chorus)\n" +
                        "    -(Chorus) \n" +
                        "    -(Outro) \n")
                .append(ENTER +
                        "    노래가 발라드이면:\n" +
                        "    -(Verse 1)\n" +
                        "    -(Chorus)\n" +
                        "    -(Verse 2)\n" +
                        "    -(Chorus)\n" +
                        "    -(Verse 3)\n" +
                        "    -(Chorus)\n" +
                        "    -(Bridge)\n" +
                        "    -(Chorus)\n" +
                        "    -(Outro)\n")
                .append(ENTER +
                        "    노래가 힙합이면:\n" +
                        "    - (Verse 1)\n" +
                        "    - (Chorus)\n" +
                        "    - (Verse 2)\n" +
                        "    - (Chorus)\n" +
                        "    - (Verse 3)\n" +
                        "    - (Chorus)\n")
                .append(ENTER +
                        "    가사는 최소한 150자 이상으로 작성되어야 해.");
        return openAiChatModel.call(lyrics.toString());
    }

    public String translate(String text) {
        return restClient.transClient()
                .post()
                .body(TransRequestDto.builder()
                        .text(List.of(text))
                        .source_lang("KO")
                        .target_lang("EN")
                        .build()
                )
                .retrieve()
                .body(TransResponseDto.class)
                .getTranslations().get(0).getText();
    }

    public List<MainMusicResponseDto> findFourMusic() {
        List<MainMusicResponseDto> list = musicRepository.findByFourMusic().stream().map(i -> MainMusicResponseDto.builder()
                .musicId(String.valueOf(i.getMusicId()))
                .musicTitle(i.getMusicTitle())
                .musicImage(i.getMusicImage())
                .userNickName(i.getUser().getNickName())
                .build()).collect(Collectors.toList());

        return list;
    }
}
