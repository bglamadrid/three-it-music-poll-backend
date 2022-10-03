package cl.bglm.exams.threeit.musicpollbackend.services;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.pojo.MusicGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Main API logic service for operating with music genres.
 * Provides methods to fetch them only (as they are not meant to be altered).
 */
@Service
public class MusicGenresService {
  private final IMusicGenreJpaRepository musicGenreJpaRepository;

  @Autowired
  public MusicGenresService(IMusicGenreJpaRepository musicGenreJpaRepository) {
    this.musicGenreJpaRepository = musicGenreJpaRepository;
  }

  /**
   * Fetches all music genres stored in the database in a streamable pipeline.
   * @return A streamable collection that emits all of the music genres, in serializable POJO format.
   */
  public Stream<MusicGenre> getMusicGenres() {
    return musicGenreJpaRepository.findAll()
        .stream()
        .map((JpaMusicGenre input) -> new MusicGenre(input.getName()));
  }
}
