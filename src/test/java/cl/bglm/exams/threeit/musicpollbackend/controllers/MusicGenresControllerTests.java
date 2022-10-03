package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.pojo.MusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.services.MusicGenresService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

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

  @Test
  public void keepsGenreNames() {
    final String mockMusicGenreName = "Rock";
    Mockito.when(musicGenresService.getMusicGenres())
        .thenReturn(Stream.of(
            new MusicGenre(mockMusicGenreName)));
    Assertions.assertEquals(
        controller.getMusicGenres().get(0).getName(),
        mockMusicGenreName);
  }

}
