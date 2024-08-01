package harme.music.listening.service;

import harme.music.entity.MusicEntity;
import harme.music.listening.dto.request.MakingMusicRequestDto;
import harme.music.listening.dto.response.MusicResponseDto;
import harme.music.listening.repository.MusicRepository;
import harme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final UserRepository userRepository;

    public MusicResponseDto createMusic(MakingMusicRequestDto makingMusicRequestDto) {

        String musicTitle = "";
        String musicLyrics = "";
        String musicUrl = "";

        // TODO : user, keyword, 노래 재생한 시간 저장해야함
        MusicEntity musicEntity = MusicEntity.builder()
                .musicTitle(musicTitle)
                .musicImage(makingMusicRequestDto.getMusicImage())
                .musicLyrics(musicLyrics)
                .musicUrl(musicUrl)
                .musicCreatedAt(LocalDateTime.now())
                .build();

        musicRepository.save(musicEntity);

        return new MusicResponseDto(musicTitle, makingMusicRequestDto.getMusicImage(), musicLyrics, musicUrl);
    }

    /**
     * 노래 조회
     * @param title
     * @return
     */
    public MusicResponseDto findMusicByTitle(String title) {
        MusicEntity music = musicRepository.findByMusicTitle(title)
                .orElseThrow(() -> new RuntimeException("Music not found"));
        return new MusicResponseDto(
                music.getMusicTitle(),
                music.getMusicImage(),
                music.getMusicLyrics(),
                music.getMusicUrl()
        );
    }

    /**
     * 기록 페이지에서 7일 이내 생성된 노래 최대 2개 보기
     * @param userId
     * @param limit
     * @return
     */
    public List<MusicResponseDto> findRecentMusicByUserId(Long userId, int limit) {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        List<MusicEntity> recentMusic = musicRepository.findRecentMusic(userId, sevenDaysAgo, limit);

        return Optional.of(recentMusic)
                .filter(musicList -> !musicList.isEmpty())
                .map(musicList -> musicList.stream()
                        .map(music -> new MusicResponseDto(music.getMusicTitle(), music.getMusicImage(), null, null))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

}
