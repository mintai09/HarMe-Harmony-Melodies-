package harme.music.listening.controller;

import harme.music.listening.dto.request.ImageRequestDto;
import harme.music.listening.dto.request.ListeningMusicRequest;
import harme.music.listening.dto.request.MakingMusicRequestDto;
import harme.music.listening.dto.response.ImageResponseDto;
import harme.music.listening.dto.response.MusicResponseDto;
import harme.music.listening.service.MusicImageService;
import harme.music.listening.service.MusicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
@Tag(name = "Music-Controller", description = "음악 API")
public class MusicController {

    private final MusicImageService musicImageService;
    private final MusicService musicService;


    /**
     * 노래표지 만들기
     * @param imageRequestDto
     * @return
     */
    @PostMapping("/images")
    @Operation(summary = "노래표지 만들기", description = "키워드로 음악표지 만들기")
    public ResponseEntity<ImageResponseDto> generateImages(@RequestBody ImageRequestDto imageRequestDto) {
        ImageResponseDto imageResponse = musicImageService.generateImages(imageRequestDto);
        return ResponseEntity.ok(imageResponse);
    }


    /**
     * 노래 만들기
     * @param makingMusicRequestDto
     * @return
     */
    @PostMapping("/create")
    @Operation(summary = "노래 만들기", description = "키워드로 노래 만들기")
    public ResponseEntity<MusicResponseDto> createMusic(@RequestBody MakingMusicRequestDto makingMusicRequestDto) {
        MusicResponseDto musicResponse = musicService.createMusic(makingMusicRequestDto);
        return ResponseEntity.ok(musicResponse);
    }

    /**
     * 노래 조회하기
     * @param request
     * @return
     */
    @PostMapping("/listen")
    @Operation(summary = "노래 조회", description = "노래 조회하기")
    public ResponseEntity<MusicResponseDto> findMusicByTitle(@RequestBody ListeningMusicRequest request) {
        MusicResponseDto response = musicService.findMusicByTitle(request.getMusicTitle());
        return ResponseEntity.ok(response);
    }
}
