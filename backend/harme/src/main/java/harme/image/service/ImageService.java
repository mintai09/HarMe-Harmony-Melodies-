package harme.image.service;

import harme.image.dto.ImageRequestDto;
import harme.music.entity.MusicEntity;
import harme.music.repository.MusicsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
    private final OpenAiImageModel openAiImageModel;
    private final MusicsRepository musicRepository;

    @Transactional
    public String imageCreate(ImageRequestDto imageRequestDto) {
        ImageResponse call = openAiImageModel.call(
                new ImagePrompt(makeOrder(imageRequestDto.getLyrics(), imageRequestDto.getKeyword()),
                        OpenAiImageOptions.builder()
                                .withQuality("hd")
                                .withN(1)
//                                .withResponseFormat("b64_json")
                                .withHeight(1024)
                                .withWidth(1024)
                                .build())
        );

        log.info("url = {}", imageRequestDto);
        String b = call.getResult().getOutput().getUrl();

        MusicEntity music = musicRepository.findByMusic(imageRequestDto.getMusicId()).get();
        music.setImageUrl(b);

        log.info("b = {}", b);
        return b;
//        byte[] bytes = Base64.getDecoder().decode(b);

    }

    private String makeOrder(String lyric, String keyword) {
        StringBuffer order = new StringBuffer();

        order.append("Create an album cover for a ")
                .append(keyword)
                .append(" song. Reflect the lyrics: ")
                .append(lyric)
                .append(".\n")
                .append("    The cover should visually represent the mood and theme of the song. Do not include any text.\n")
                .append("I want good quality.");
        return order.toString();
    }

    public MusicEntity findImage(String musicId) {
        return musicRepository.findByImageUrl(musicId).get();
    }
}