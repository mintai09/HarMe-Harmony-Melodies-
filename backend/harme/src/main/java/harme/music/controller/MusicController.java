package harme.music.controller;

import groovy.util.logging.Slf4j;
import harme.global.client.RestClientConfig;
import harme.music.dto.MusicRequestDto;
import harme.music.dto.TransRequestDto;
import harme.music.dto.TransResponseDto;
import harme.music.dto.Translate;
import harme.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @PostMapping("/create")
    public ResponseEntity<?> write(@RequestBody MusicRequestDto musicRequestDto) {
        musicService.create(musicRequestDto);
        return ResponseEntity.ok().build();
    }
}
