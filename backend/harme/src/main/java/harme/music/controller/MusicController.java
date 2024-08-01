package harme.music.controller;

import groovy.util.logging.Slf4j;
import harme.music.dto.MainMusicResponseDto;
import harme.music.dto.MusicRequestDto;
import harme.music.dto.MusicResponseDto;
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
    public ResponseEntity<MusicResponseDto> write(@RequestBody MusicRequestDto musicRequestDto) {
        return ResponseEntity.ok().body(musicService.create(musicRequestDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<MainMusicResponseDto>> getFourMusic() {
        return ResponseEntity.ok(musicService.findFourMusic());
    }
}
