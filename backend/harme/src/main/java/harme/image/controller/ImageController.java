package harme.image.controller;

import groovy.util.logging.Slf4j;
import harme.image.dto.ImageRequestDto;
import harme.image.dto.ImageResponseDto;
import harme.image.service.ImageService;
import harme.music.entity.MusicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/create")
    public ResponseEntity<String> imageCreate(@RequestBody ImageRequestDto imageRequestDto) {
        return ResponseEntity.ok(imageService.imageCreate(imageRequestDto));
    }

    @GetMapping("/find")
    public ResponseEntity<ImageResponseDto> findImage(@RequestParam String musicId) {
        MusicEntity music = imageService.findImage(musicId);
        return ResponseEntity.ok(ImageResponseDto.builder()
                .musicName(music.getMusicName())
                .musicImage(music.getMusicImage())
                .musicCreatedAt(music.getMusicCreatedAt())
                .musicId(music.getMusicId())
                .musicTitle(music.getMusicTitle())
                .musicLyrics(music.getMusicLyrics())
                .musicUrl(music.getMusicUrl())
                .userNickName(music.getUser().getNickName())
                .build());
    }
}
