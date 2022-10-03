package cl.bglm.exams.threeit.musicpollbackend.controllers;

import cl.bglm.exams.threeit.musicpollbackend.services.PollAnswersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PollAnswersControllerTests {
  @Mock static PollAnswersService pollAnswersService;
  private PollAnswersController controller;

  @BeforeEach
  public void init() {
    this.controller = new PollAnswersController(pollAnswersService);
  }

  @Test
  public void delegatesFetchCallToService() {
    controller.getPollAnswers();
    Mockito.verify(pollAnswersService).getPollAnswers();
  }

}
