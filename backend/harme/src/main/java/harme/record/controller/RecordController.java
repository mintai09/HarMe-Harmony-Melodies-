package harme.record.controller;

import harme.music.listening.dto.response.MusicResponseDto;
import harme.record.dto.request.RecordDetailRequestDto;
import harme.record.dto.request.RecordMakingRequestDto;
import harme.record.dto.response.RecordDetailResponseDto;
import harme.record.dto.response.RecordResponseDto;
import harme.record.service.RecordService;
import harme.music.listening.service.OPService;
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

    private final OPService musicService;
    private final RecordService recordService;


    /**
     * 최근 7일 내에 제작된 음악 최대 2개 보기
     * @param userId
     * @return
     */
    @GetMapping("/recent-music")
    public ResponseEntity<List<MusicResponseDto>> getRecentMusic(@RequestParam Long userId) {
        List<MusicResponseDto> recentMusic = musicService.findRecentMusicByUserId(userId, 2);
        return ResponseEntity.ok(recentMusic);
    }


    /**
     * 지난 음성 기록 최대 3개 보기
     * @param userId
     * @return
     */

    @GetMapping("/recent-records")
    public ResponseEntity<List<RecordResponseDto>> getRecentRecords(@RequestParam Long userId) {
        List<RecordResponseDto> recentRecords = recordService.findRecentRecordsByUserId(userId, 3);
        return ResponseEntity.ok(recentRecords);
    }


    /**
     * 음성 기록 전부 보기
     * @param userId
     * @return
     */
    @GetMapping("/all")
    public List<RecordResponseDto> getAllRecords(@RequestParam Long userId) {
        return recordService.findAllRecordsByUserId(userId);
    }


    /**
     * 음성 기록 자세히 보기
     * @param requestDto
     * @return
     */
    @PostMapping("/detail")
    public RecordDetailResponseDto getRecordDetail(@RequestBody RecordDetailRequestDto requestDto) {
        return recordService.getRecordDetail(requestDto);
    }

    /**
     * 기록 생성하기
     * @param requestDto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<RecordDetailResponseDto> createRecord(@RequestBody RecordMakingRequestDto requestDto) {
        RecordDetailResponseDto response = recordService.createRecord(requestDto);
        return ResponseEntity.ok(response);
    }

    /**
     * 기록 삭제하기
     * @param userId
     * @param recordId
     * @return
     */
    @DeleteMapping("/{userId}/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long userId, @PathVariable Long recordId) {
        recordService.deleteRecord(userId, recordId);
        return ResponseEntity.noContent().build();
    }
}