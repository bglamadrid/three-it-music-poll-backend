package cl.bglm.exams.threeit.musicpollbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JSON-serializable POJO that represents a single record of a given answer to the poll.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollAnswer {
  public String mail;
  public String musicGenre;
}
