package harme.record.entity;

import harme.music.entity.MusicEntity;
import harme.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "record")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "music_id", nullable = false)
    private MusicEntity music;

    @Column(name = "record_title", nullable = false)
    private String recordTitle;

    @Column(name = "record_created_at", nullable = false)
    private Timestamp recordCreatedAt;

    @Column(name = "record_comment", nullable = false)
    private String recordComment;

    @Column(name = "record_file", nullable = false)
    private String recordFile;
}
