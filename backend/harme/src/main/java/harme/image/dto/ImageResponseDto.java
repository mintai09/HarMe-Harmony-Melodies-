package harme.image.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ImageResponseDto {
    private Long musicId;
    private String musicName;
    private String musicTitle;
    private String musicImage;
    private String musicLyrics;
    private String musicUrl;
    private LocalDateTime musicCreatedAt;
    private String userNickName;

    @Builder
    ImageResponseDto(Long musicId, String musicName, String musicTitle, String musicImage, String musicLyrics, String musicUrl, LocalDateTime musicCreatedAt, String userNickName){
        this.musicId = musicId;
        this.musicName= musicName;
        this.musicTitle = musicTitle;
        this.musicImage = musicImage;
        this.musicLyrics = musicLyrics;
        this.musicUrl = musicUrl;
        this.musicCreatedAt = musicCreatedAt;
        this.userNickName = userNickName;
    }


}