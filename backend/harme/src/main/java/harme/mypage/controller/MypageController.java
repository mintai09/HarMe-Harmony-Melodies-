package harme.mypage.controller;

import harme.mypage.dto.MypageResponseDto;
import harme.mypage.service.MypageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
@Tag(name = "Mypage-Controller", description = "마이페이지 API")
public class MypageController {

    private final MypageService mypageService;


    /**
     * 사용자의 노래리스트 보기
     * @param userId
     * @return
     */
    @GetMapping("/songs/{userId}")
    public ResponseEntity<List<MypageResponseDto>> getUserPlayedMusic(@PathVariable Long userId) {
        List<MypageResponseDto> musicList = mypageService.getUserPlayedMusic(userId);
        return ResponseEntity.ok(musicList);
    }
}
