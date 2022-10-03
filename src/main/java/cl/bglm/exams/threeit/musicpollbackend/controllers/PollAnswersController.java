package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaPollAnswer;
import cl.bglm.exams.threeit.musicpollbackend.pojo.PollAnswer;
import cl.bglm.exams.threeit.musicpollbackend.services.PollAnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * API controller for operations with poll answers.
 */
@RestController
@RequestMapping("/v1/poll_answers")
public class PollAnswersController {
  private final PollAnswersService pollAnswersService;

  @Autowired
  public PollAnswersController(
      PollAnswersService pollAnswersService
  ) {
    this.pollAnswersService = pollAnswersService;
  }

  @GetMapping
  public List<PollAnswer> getPollAnswers() {
    return pollAnswersService.getPollAnswers()
        .toList();
  }

  @PostMapping
  public ResponseEntity<PollAnswer> save(@RequestBody PollAnswer pollAnswer) throws RuntimeException {
    Optional<JpaPollAnswer> jpaPollAnswer = pollAnswersService.validateAnswer(pollAnswer);
    if (jpaPollAnswer.isPresent()) {
      pollAnswersService.saveAnswer(jpaPollAnswer.get());
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> handleExceptions() {
    return ResponseEntity.internalServerError().build();
  }

}
