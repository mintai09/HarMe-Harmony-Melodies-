package harme.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordMakingRequestDto {
    private Long userId;
    private Long recordId;
    private String recordComment;
}
