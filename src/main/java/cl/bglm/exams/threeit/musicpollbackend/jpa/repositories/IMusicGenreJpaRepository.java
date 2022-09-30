package cl.bglm.exams.threeit.musicpollbackend.jpa.repositories;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JPA repository for music genres table. For data fetching only.
 */
@Repository
public interface IMusicGenreJpaRepository
  extends org.springframework.data.repository.Repository<JpaMusicGenre, Long> {

  List<JpaMusicGenre> findAll();

}
