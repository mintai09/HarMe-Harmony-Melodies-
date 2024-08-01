package harme.music.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MainMusicResponseDto {
    private String musicId;
    private String musicTitle;
    private String musicImage;
    private String userNickName;

    @Builder
    MainMusicResponseDto(String musicId, String musicTitle, String musicImage, String userNickName) {
        this.musicId = musicId;
        this.musicTitle = musicTitle;
        this.musicImage = musicImage;
        this.userNickName = userNickName;
    }
}
