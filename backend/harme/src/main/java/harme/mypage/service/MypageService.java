package harme.mypage.service;

import harme.music.entity.MusicEntity;
import harme.mypage.dto.Response.MypageResponseDto;
import harme.mypage.repository.MypageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MypageRepository mypageRepository;

    public List<MypageResponseDto> getUserPlayedMusic(Long userId) {
        List<MusicEntity> musicEntities = mypageRepository.findMusicByUserIdOrderByPlayTimeDesc(userId);

        return musicEntities.stream()
                .map(music -> new MypageResponseDto(
                        music.getMusicTitle(),
                        music.getMusicImage(),
                        music.getMusicLyrics(),
                        music.getMusicUrl()
                ))
                .collect(Collectors.toList());
    }
}
