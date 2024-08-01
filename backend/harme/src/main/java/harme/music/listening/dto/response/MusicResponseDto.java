package harme.music.listening.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MusicResponseDto {
    private String musicTitle;
    private String musicImage;
    private String musicLyrics;
    private String musicUrl;
}