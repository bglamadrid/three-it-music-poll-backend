package cl.bglm.exams.threeit.musicpollbackend.services;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaMusicGenre;
import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaPollAnswer;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IMusicGenreJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.jpa.repositories.IPollAnswerJpaRepository;
import cl.bglm.exams.threeit.musicpollbackend.pojo.PollAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PollAnswersService {
  private final IPollAnswerJpaRepository pollAnswerJpaRepository;
  private final IMusicGenreJpaRepository musicGenreJpaRepository;

  @Autowired
  public PollAnswersService(
      IPollAnswerJpaRepository pollAnswerJpaRepository,
      IMusicGenreJpaRepository musicGenreJpaRepository
  ) {
    this.pollAnswerJpaRepository = pollAnswerJpaRepository;
    this.musicGenreJpaRepository = musicGenreJpaRepository;
  }

  /**
   * Validates an input object that may resemble a poll answer.
   * @param input An instance of poll answers.
   * @return An optional with a entity instance, if valid for submission. Otherwise, an empty optional.
   */
  public Optional<JpaPollAnswer> validateAnswer(PollAnswer input) {
    if (input.getMail() != null && !input.getMail().isBlank() &&
        input.getMusicGenre() != null && !input.getMusicGenre().isBlank()) {
      Optional<JpaMusicGenre> byName = musicGenreJpaRepository.findByName(input.getMusicGenre());
      if (byName.isPresent()) {
        return Optional.of(
            new JpaPollAnswer(null, input.getMail(), byName.get()));
      }
    }
    return Optional.empty();
  }

  /**
   * Saves the answer in the data store.
   * @param entity The entity to be saved.
   * @throws RuntimeException Rethrows any one raised by the IPollAnswerJpaRepository implementation
   */
  @Transactional
  public void saveAnswer(JpaPollAnswer entity) throws RuntimeException {
    pollAnswerJpaRepository.save(entity);
  }


}
