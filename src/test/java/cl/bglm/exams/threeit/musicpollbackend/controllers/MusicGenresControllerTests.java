package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Assertions;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MusicGenresControllerTests {
  @Mock static IMusicGenreJpaRepository iMusicGenreJpaRepository;
  private MusicGenresController controller;

  @BeforeEach
  public void init() {
    this.controller = new MusicGenresController(iMusicGenreJpaRepository);
  }

  @Test
  public void delegatesFetchCallToRepository() {
    controller.getMusicGenres();
    Mockito.verify(iMusicGenreJpaRepository).findAll();
  }

  @Test
  public void keepsGenreNames() {
    final Long mockMusicGenreId = 1L;
    final String mockMusicGenreName = "Rock";
    Mockito.when(iMusicGenreJpaRepository.findAll())
        .thenReturn(List.of(
            new JpaMusicGenre(mockMusicGenreId, mockMusicGenreName)));
    Assertions.assertEquals(
        controller.getMusicGenres().get(0).getName(),
        mockMusicGenreName);
  }

}
