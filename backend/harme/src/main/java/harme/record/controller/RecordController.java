package harme.record.controller;

import harme.music.listening.dto.response.MusicResponseDto;
import harme.record.dto.request.RecordDetailRequestDto;
import harme.record.dto.request.RecordMakingRequestDto;
import harme.record.dto.response.RecordDetailResponseDto;
import harme.record.dto.response.RecordResponseDto;
import harme.record.service.RecordService;
import harme.music.listening.service.MusicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
@Tag(name = "Record-Controller", description = "레코드 API")
public class RecordController {

    private final MusicService musicService;
    private final RecordService recordService;

    @GetMapping("/recent-music")
    public ResponseEntity<List<MusicResponseDto>> getRecentMusic(@RequestParam Long userId) {
        List<MusicResponseDto> recentMusic = musicService.findRecentMusicByUserId(userId, 2);
        return ResponseEntity.ok(recentMusic);
    }

    @GetMapping("/recent-records")
    public ResponseEntity<List<RecordResponseDto>> getRecentRecords(@RequestParam Long userId) {
        List<RecordResponseDto> recentRecords = recordService.findRecentRecordsByUserId(userId, 3);
        return ResponseEntity.ok(recentRecords);
    }

    @GetMapping("/all")
    public List<RecordResponseDto> getAllRecords(@RequestParam Long userId) {
        return recordService.findAllRecordsByUserId(userId);
    }

    @PostMapping("/detail")
    public RecordDetailResponseDto getRecordDetail(@RequestBody RecordDetailRequestDto requestDto) {
        return recordService.getRecordDetail(requestDto);
    }

    // Record 생성
    @PostMapping("/create")
    public ResponseEntity<RecordDetailResponseDto> createRecord(@RequestBody RecordMakingRequestDto requestDto) {
        RecordDetailResponseDto response = recordService.createRecord(requestDto);
        return ResponseEntity.ok(response);
    }

    // Record 삭제
    @DeleteMapping("/{userId}/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long userId, @PathVariable Long recordId) {
        recordService.deleteRecord(userId, recordId);
        return ResponseEntity.noContent().build();
    }
}