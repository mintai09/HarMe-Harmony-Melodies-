package harme.record.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDetailResponseDto {

    private String musicImage;
    private String musicTitle;
    private String musicCreatedAt;

    private String recordComment;
    private String nickName;
    private String recordFile;
}
