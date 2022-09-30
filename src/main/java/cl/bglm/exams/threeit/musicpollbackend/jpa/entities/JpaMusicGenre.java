package cl.bglm.exams.threeit.musicpollbackend.jpa.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Entity class for music genres.
 */
@Data
@Entity
@Table(name = "music_genres")
public class JpaMusicGenre {
  @Id
  @Column(name = "music_genre_id")
  private Long id;
  @NotBlank
  @Column(name = "music_genre_name", length = 40, unique = true)
  private String name;
}
