package harme.music.listening.repository;

import harme.music.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<MusicEntity, Long> {
    Optional<MusicEntity> findByMusicTitle(String musicTitle);
//    List<MusicEntity> findTopByUserIdAndMusicCreatedAtAfterOrderByMusicCreatedAtDesc(Long userId, LocalDateTime musicCreatedAt, int limit);

    @Query(value = "SELECT * FROM music WHERE user = :userId AND music_created_at > :sevenDaysAgo ORDER BY music_created_at DESC LIMIT :limit", nativeQuery = true)
    List<MusicEntity> findRecentMusic(@Param("userId") Long userId, @Param("sevenDaysAgo") LocalDateTime sevenDaysAgo, @Param("limit") int limit);
}
