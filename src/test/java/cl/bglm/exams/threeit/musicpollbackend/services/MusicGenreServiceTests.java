package cl.bglm.exams.threeit.musicpollbackend.services;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MusicGenreServiceTests {

  @Mock static IMusicGenreJpaRepository musicGenreJpaRepository;
  private MusicGenresService service;

  @BeforeEach
  public void init() {
    this.service = new MusicGenresService(musicGenreJpaRepository);
  }

  @Test
  public void keepsGenreNames() {
    final Long mockMusicGenreId = 1L;
    final String mockMusicGenreName = "Rock";
    Mockito.when(musicGenreJpaRepository.findAll())
        .thenReturn(List.of(
            new JpaMusicGenre(mockMusicGenreId, mockMusicGenreName)));
    Assertions.assertEquals(
        service.getMusicGenres().iterator().next().getName(),
        mockMusicGenreName);
  }
}
