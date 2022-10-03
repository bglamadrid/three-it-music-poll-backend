package cl.bglm.exams.threeit.musicpollbackend.services;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaPollAnswer;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IPollAnswerJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.pojo.PollAnswer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PollAnswerServiceTests {

  @Mock static IPollAnswerJpaRepository pollAnswerJpaRepository;
  @Mock static IMusicGenreJpaRepository musicGenreJpaRepository;

  static final String[] EMPTY_STRINGS = {null, "", " "};
  static final String MOCK_MAIL = "test@example.com";
  static final String MOCK_GENRE_NAME = "Rock";
  private PollAnswersService service;

  @BeforeEach
  public void init() {
    this.service = new PollAnswersService(
        pollAnswerJpaRepository,
        musicGenreJpaRepository);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2})
  public void rejectsEmptyMailsInAnswers(int index) {
    final PollAnswer someAnswer = new PollAnswer(EMPTY_STRINGS[index], MOCK_GENRE_NAME);
    Assertions.assertFalse(
      service.validateAnswer(someAnswer).isPresent());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2})
  public void rejectsEmptyMusicGenresInAnswers(int index) {
    final PollAnswer someAnswer = new PollAnswer(MOCK_MAIL, EMPTY_STRINGS[index]);
    Assertions.assertFalse(
        service.validateAnswer(someAnswer).isPresent());
  }

  @Test
  public void attemptsToMatchMusicGenreNameAgainstRepository() {
    Mockito.when(musicGenreJpaRepository.findByName(Mockito.anyString())).thenReturn(
        Optional.empty());
    final PollAnswer someAnswer = new PollAnswer(MOCK_MAIL, MOCK_GENRE_NAME);
    service.validateAnswer(someAnswer);
    Mockito.verify(musicGenreJpaRepository).findByName(MOCK_GENRE_NAME);
  }

  @Test
  public void preparesMatchingEntityForSubmission() {
    Mockito.when(musicGenreJpaRepository.findByName(MOCK_GENRE_NAME)).thenReturn(
        Optional.of(new JpaMusicGenre(1L, MOCK_GENRE_NAME)));
    final PollAnswer someAnswer = new PollAnswer(MOCK_MAIL, MOCK_GENRE_NAME);
    Optional<JpaPollAnswer> result = service.validateAnswer(someAnswer);
    Assertions.assertTrue(result.isPresent());
    JpaPollAnswer answer = result.get();
    Assertions.assertEquals(answer.getMail(), someAnswer.getMail());
    Assertions.assertEquals(answer.getMusic_genre().getName(), someAnswer.getMusicGenre());
  }
}
