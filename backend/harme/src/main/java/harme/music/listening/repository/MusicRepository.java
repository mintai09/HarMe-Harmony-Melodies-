package harme.music.listening.repository;

import harme.music.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<MusicEntity, Long> {
    Optional<MusicEntity> findByMusicTitle(String musicTitle);
}
