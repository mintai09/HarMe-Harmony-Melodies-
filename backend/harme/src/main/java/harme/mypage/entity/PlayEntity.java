package harme.mypage.entity;

import harme.music.entity.MusicEntity;
import harme.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "play")
public class PlayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "play_id")
    private Long playId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "music_id", nullable = false)
    private MusicEntity music;

    @Column(name = "play_time", nullable = false)
    private Timestamp playTime;
}
