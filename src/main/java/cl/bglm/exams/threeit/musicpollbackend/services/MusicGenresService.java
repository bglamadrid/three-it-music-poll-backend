package cl.bglm.exams.threeit.musicpollbackend.services;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.pojo.MusicGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MusicGenresService {
  private final IMusicGenreJpaRepository musicGenreJpaRepository;

  @Autowired
  public MusicGenresService(IMusicGenreJpaRepository musicGenreJpaRepository) {
    this.musicGenreJpaRepository = musicGenreJpaRepository;
  }

  public Stream<MusicGenre> getMusicGenres() {
    return musicGenreJpaRepository.findAll()
        .stream()
        .map((JpaMusicGenre input) -> new MusicGenre(input.getName()));
  }
}
