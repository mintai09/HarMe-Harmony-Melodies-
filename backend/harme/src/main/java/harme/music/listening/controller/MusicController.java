package harme.music.listening.controller;

import harme.music.listening.dto.request.ImageRequestDto;
import harme.music.listening.dto.request.MusicRequestDto;
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

    @PostMapping("/generate-images")
    @Operation(summary = "노래표지 만들기", description = "키워드로 음악표지 만들음")
    public ResponseEntity<ImageResponseDto> generateImages(@RequestBody ImageRequestDto imageRequestDto) {
        ImageResponseDto imageResponse = musicImageService.generateImages(imageRequestDto);
        return ResponseEntity.ok(imageResponse);
    }

    @PostMapping("/create")
    @Operation(summary = "음악 만들기", description = "키워드로 음악 만들음")
    public ResponseEntity<MusicResponseDto> createMusic(@RequestBody MusicRequestDto musicRequestDto) {
        MusicResponseDto musicResponse = musicService.createMusic(musicRequestDto);
        return ResponseEntity.ok(musicResponse);
    }
}
