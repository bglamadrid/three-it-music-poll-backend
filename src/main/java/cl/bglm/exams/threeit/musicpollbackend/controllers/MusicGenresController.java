package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.pojo.MusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.services.MusicGenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * API controller for operations with music genres.
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/music_genres")
public class MusicGenresController {
  private final MusicGenresService musicGenresService;

  @Autowired
  public MusicGenresController(
      MusicGenresService musicGenresService
  ) {
    this.musicGenresService = musicGenresService;
  }

  @GetMapping
  public List<MusicGenre> getMusicGenres() {
    return musicGenresService.getMusicGenres()
        .toList();
  }

}
