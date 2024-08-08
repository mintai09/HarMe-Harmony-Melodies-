package harme.music.entity;

import harme.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "musics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    private Long musicId;

    @Column(name = "music_name", nullable = false, unique = true)
    private String musicName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "music_title", nullable = false)
    private String musicTitle;

    //    @Lob
    @Column(name = "music_image", length = 500)
    private String musicImage;

    @Column(name = "music_lyrics", nullable = false, length = 2000)
    private String musicLyrics;

    @Column(name = "music_url", nullable = false, length = 1000)
    private String musicUrl;

    @Column(name = "music_created_at")
    private LocalDateTime musicCreatedAt;

    @Builder
    MusicEntity(String musicName, Long userId, String musicTitle, String musicImage, String musicLyrics, String musicUrl, LocalDateTime musicCreatedAt) {
        this.musicName = musicName;
        this.user_id = userId;
        this.musicTitle = musicTitle;
        this.musicImage = musicImage;
        this.musicLyrics = musicLyrics;
        this.musicUrl = musicUrl;
        this.musicCreatedAt = musicCreatedAt;
    }

    public void setImageUrl(String imageUrl) {
        this.musicImage = imageUrl;
    }
}