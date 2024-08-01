package harme.music.repository;

import harme.music.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MusicsRepository extends JpaRepository<MusicEntity, Long> {
    @Query("SELECT m FROM musics m WHERE m.musicName like :musicId")
    Optional<MusicEntity> findByImageUrl(@Param("musicId") String musicId);

    @Query("SELECT m FROM musics m WHERE m.musicName like :musicId")
    Optional<MusicEntity> findByMusic(@Param("musicId") String musicId);

    @Query(value = "SELECT * FROM musics ORDER BY music_created_at DESC LIMIT 4", nativeQuery = true)
    List<MusicEntity> findByFourMusic();
}
