package harme.music.entity;

import harme.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "music_keyword", nullable = false)
    private String musicKeyword;

    @Column(name = "music_title", length = 50, nullable = false)
    private String musicTitle;

    @Column(name = "music_image", nullable = false)
    private String musicImage;

    @Column(name = "music_lyrics", columnDefinition = "TEXT", nullable = false)
    private String musicLyrics;

    @Column(name = "music_url", columnDefinition = "TEXT", nullable = false)
    private String musicUrl;
}