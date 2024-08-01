package harme.record.repository;

import harme.record.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
//    List<RecordEntity> findTopByUserIdOrderByRecordCreatedAtDesc(Long userId, int limit);

    @Query(value = "SELECT * FROM record WHERE user = :userId AND record_created_at > :now ORDER BY record_created_at DESC LIMIT :limit", nativeQuery = true)
    List<RecordEntity> findRecentRecords(@Param("userId") Long userId, @Param("now") LocalDateTime now, @Param("limit") int limit);

    @Query("SELECT r FROM RecordEntity r WHERE r.user.id = :userId")
    List<RecordEntity> findAllByUserId(@Param("userId") Long userId);

    @Query("SELECT r FROM RecordEntity r WHERE r.user.id = :userId AND r.recordId = :recordId")
    RecordEntity findByUserIdAndRecordId(@Param("userId") Long userId, @Param("recordId") Long recordId);
}
