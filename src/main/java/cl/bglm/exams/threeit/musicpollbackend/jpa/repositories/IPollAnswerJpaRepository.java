package cl.bglm.exams.threeit.musicpollbackend.jpa.repositories;

import cl.bglm.exams.threeit.musicpollbackend.jpa.entities.JpaPollAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPollAnswerJpaRepository
  extends org.springframework.data.repository.Repository<JpaPollAnswer, Long> {

  List<JpaPollAnswer> findAll();

  JpaPollAnswer save(JpaPollAnswer entity);

}
