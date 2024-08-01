package harme.mypage.repository;

import harme.mypage.entity.PlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MypageRepository extends JpaRepository<PlayEntity, Long> {

    @Query("SELECT p FROM PlayEntity p WHERE p.userId = :userId ORDER BY p.playTime DESC")
    List<PlayEntity> findPlaysByUserIdOrderByPlayTimeDesc(@Param("userId") Long userId);
}

