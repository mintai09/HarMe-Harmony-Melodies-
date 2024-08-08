package harme.record.service;

import harme.music.entity.MusicEntity;
import harme.music.listening.repository.MusicRepository;
import harme.record.dto.RecordDetailRequestDto;
import harme.record.dto.RecordMakingRequestDto;
import harme.record.dto.RecordDetailResponseDto;
import harme.record.dto.RecordResponseDto;
import harme.record.entity.RecordEntity;
import harme.record.repository.RecordRepository;
import harme.user.entity.UserEntity;
import harme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final MusicRepository musicRepository;
    private final UserRepository userRepository;


    /**
     * 지난 음성 기록 최대 3개 보기
     * @param userId
     * @param limit
     * @return
     */
    public List<RecordResponseDto> findRecentRecordsByUserId(Long userId, int limit) {
        LocalDateTime now = LocalDateTime.now();
        List<RecordEntity> recentRecords = recordRepository.findRecentRecords(userId, now, limit);

        return recentRecords.stream()
                .map(record -> {
                    MusicEntity music = musicRepository.findById(record.getMusic().getMusicId()).orElse(null);
                    String musicTitle = Optional.ofNullable(music)
                            .map(MusicEntity::getMusicTitle)
                            .orElse("");
                    return new RecordResponseDto(record.getRecordTitle(), record.getRecordCreatedAt(), musicTitle);
                })
                .collect(Collectors.toList());
    }


    /**
     * 음성 기록 전부 보기
     * @param userId
     * @return
     */
    public List<RecordResponseDto> findAllRecordsByUserId(Long userId) {
        List<RecordEntity> allRecords = recordRepository.findAllByUserId(userId);

        return allRecords.stream()
                .map(record -> {
                    MusicEntity music = musicRepository.findById(record.getMusic().getMusicId()).orElse(null);
                    String musicTitle = Optional.ofNullable(music)
                            .map(MusicEntity::getMusicTitle)
                            .orElse("");
                    return new RecordResponseDto(record.getRecordTitle(), record.getRecordCreatedAt(), musicTitle);
                })
                .collect(Collectors.toList());
    }


    /**
     * 음성 기록 자세히 보기
     * @param requestDto
     * @return
     */
    public RecordDetailResponseDto getRecordDetail(RecordDetailRequestDto requestDto) {
        Long userId = requestDto.getUserId();
        Long recordId = requestDto.getRecordId();

        RecordEntity record = recordRepository.findByUserIdAndRecordId(userId, recordId);

        MusicEntity music = record.getMusic();
        UserEntity user = record.getUser();

//        String musicImage = music.getImageUrl();
        String musicImage = "";
        String musicTitle = music.getMusicTitle();
//        String musicCreatedAt = music.getCreatedAt().toString();
        String musicCreatedAt = "";

        String recordComment = record.getRecordComment();
        String nickName = user.getNickName();
        String recordFile = record.getRecordTitle();

        return new RecordDetailResponseDto(musicImage, musicTitle, musicCreatedAt, recordComment, nickName, recordFile);
    }

    /**
     * 기록 생성하기
     * @param requestDto
     * @return
     */
    public RecordDetailResponseDto createRecord(RecordMakingRequestDto requestDto) {
        UserEntity user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        MusicEntity music = musicRepository.findById(requestDto.getRecordId()).orElseThrow(() -> new RuntimeException("Music not found"));

        RecordEntity record = RecordEntity.builder()
                .user(user)
                .music(music)
                .recordTitle("Sample Record Title")
                .recordCreatedAt(new Timestamp(System.currentTimeMillis()))
                .recordComment(requestDto.getRecordComment())
                .build();

        recordRepository.save(record);

        return new RecordDetailResponseDto(
                music.getMusicImage(),
                music.getMusicTitle(),
                music.getMusicCreatedAt().toString(),
                record.getRecordComment(),
                user.getNickName(),
                "SampleRecordFile"
        );
    }

    /**
     * 기록 삭제하기
     * @param userId
     * @param recordId
     */
    public void deleteRecord(Long userId, Long recordId) {
        RecordEntity record = recordRepository.findByUserIdAndRecordId(userId, recordId);
        if (record != null) {
            recordRepository.delete(record);
        } else {
            throw new RuntimeException("Record not found");
        }
    }
}