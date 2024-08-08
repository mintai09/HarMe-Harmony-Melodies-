package harme.record.dto;

import harme.music.listening.dto.response.MusicResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LatestRecordsAndMusicResponse {
    private List<MusicResponseDto> recentMusic;
    private List<RecordResponseDto> recentRecords;
}
