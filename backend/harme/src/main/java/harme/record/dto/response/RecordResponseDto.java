package harme.record.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordResponseDto {
    private String recordTitle;
    private Timestamp recordCreatedAt;
    private String musicTitle;
}