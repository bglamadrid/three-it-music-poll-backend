package cl.bglm.exams.threeit.musicpollbackend.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty("music_genre_name")
  private String name;
}
