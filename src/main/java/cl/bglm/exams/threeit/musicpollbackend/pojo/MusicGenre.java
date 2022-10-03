package cl.bglm.exams.threeit.musicpollbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JSON-serializable POJO that represents a single record of a music genre listed in the underlying database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class MusicGenre {
  private String name;
}
