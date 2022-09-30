package cl.bglm.exams.threeit.musicpollbackend.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Entity class for music genres.
 */
@Entity
@Table(name = "music_genres")
public class JpaMusicGenre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "music_genre_id")
  @Getter @Setter
  private Long id;
  @NotBlank
  @Column(name = "music_genre_name", length = 40, unique = true, nullable = false)
  @Getter @Setter
  private String name;
}
