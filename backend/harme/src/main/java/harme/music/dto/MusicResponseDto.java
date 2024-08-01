package harme.music.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MusicResponseDto {
    private String musicId;
    private String keyword;
    private String lyrics;

    @Builder
    MusicResponseDto(String musicId, String keyword, String lyrics) {
        this.musicId = musicId;
        this.keyword = keyword;
        this.lyrics = lyrics;
    }
}
