package harme.music.entity;

import harme.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "music")
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    private Long musicId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "music_title", nullable = false)
    private String musicTitle;

    @Column(name = "music_image", nullable = false)
    private String musicImage;

    @Column(name = "music_lyrics", nullable = false)
    private String musicLyrics;

    @Column(name = "music_url", nullable = false)
    private String musicUrl;

    @Column(name = "music_created_at")
    private LocalDateTime musicCreatedAt;
}