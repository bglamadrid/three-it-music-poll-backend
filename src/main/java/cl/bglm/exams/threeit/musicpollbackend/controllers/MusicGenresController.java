package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.pojo.MusicGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/music_genres")
public class MusicGenresController {
  private final IMusicGenreJpaRepository iMusicGenreJpaRepository;

  @Autowired
  public MusicGenresController(
      IMusicGenreJpaRepository iMusicGenreJpaRepository
  ) {
    this.iMusicGenreJpaRepository = iMusicGenreJpaRepository;
  }

  @GetMapping
  public List<MusicGenre> getMusicGenres() {
    return iMusicGenreJpaRepository.findAll()
        .stream()
        .map((JpaMusicGenre input) -> new MusicGenre(input.getName()))
        .toList();
  }

}
