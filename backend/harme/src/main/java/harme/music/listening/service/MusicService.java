package harme.music.listening.service;

import harme.music.entity.MusicEntity;
import harme.music.listening.dto.request.MusicRequestDto;
import harme.music.listening.dto.response.MusicResponseDto;
import harme.music.listening.repository.MusicRepository;
import harme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final UserRepository userRepository;


    public MusicResponseDto createMusic(MusicRequestDto musicRequestDto) {

        String musicTitle = "";
        String musicLyrics = "";
        String musicUrl = "";

        // TODO : user, keyword, 노래 재생한 시간 저장해야함
        MusicEntity musicEntity = MusicEntity.builder()
                .musicTitle(musicTitle)
                .musicImage(musicRequestDto.getMusicImage())
                .musicLyrics(musicLyrics)
                .musicUrl(musicUrl)
                .build();

        musicRepository.save(musicEntity);

        return new MusicResponseDto(musicTitle, musicRequestDto.getMusicImage(), musicLyrics, musicUrl);
    }
}
