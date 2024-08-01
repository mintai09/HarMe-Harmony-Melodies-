package harme.music.listening.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequestDto {
    private Long userId;
    private String genre;
    private String feeling;
    private String voiceType;
}