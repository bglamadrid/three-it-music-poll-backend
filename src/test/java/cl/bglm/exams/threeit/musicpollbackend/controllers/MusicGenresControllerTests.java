package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.services.MusicGenresService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MusicGenresControllerTests {
  @Mock static MusicGenresService musicGenresService;
  private MusicGenresController controller;

  @BeforeEach
  public void init() {
    this.controller = new MusicGenresController(musicGenresService);
  }

  @Test
  public void delegatesFetchCallToService() {
    controller.getMusicGenres();
    Mockito.verify(musicGenresService).getMusicGenres();
  }

}
