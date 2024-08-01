package harme.record.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDetailRequestDto {
    private Long userId;
    private Long recordId;
}
