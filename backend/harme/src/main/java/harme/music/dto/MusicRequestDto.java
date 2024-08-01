package harme.music.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MusicRequestDto {
    private String feel;
    private String genre;
    private String singerGender;

    public String concatString() {
        return this.feel + ", " + this.genre + ", " + this.singerGender;
    }
}
