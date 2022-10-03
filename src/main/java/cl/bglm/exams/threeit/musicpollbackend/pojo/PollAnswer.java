package cl.bglm.exams.threeit.musicpollbackend.pojo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollAnswer {
  public String mail;
  public String musicGenre;
}
