package harme.image.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageRequestDto {
    private String nickName;
    private String lyric;
    private String keyword;
}
