package harme.mypage.service;

import harme.mypage.dto.MypageResponseDto;
import harme.mypage.repository.MypageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MypageRepository mypageRepository;


    /**
     * 사용자의 노래리스트 보기
     * @param userId
     * @return
     */
    public List<MypageResponseDto> getUserPlayedMusic(Long userId) {
        return mypageRepository.findPlaysByUserIdOrderByPlayTimeDesc(userId).stream()
                .map(play -> new MypageResponseDto(
                        play.getMusic().getMusicTitle(),
                        play.getMusic().getMusicImage()
                ))
                .collect(Collectors.toList());
    }
}
