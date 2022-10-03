package cl.bglm.exams.threeit.musicpollbackend.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity class for poll answers. Its 'mail' field has an identifying, unique key constraint.
 */
@Entity
@Table(name = "poll_answers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JpaPollAnswer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "poll_answer_id", nullable = false)
  private Long id;

  @Column(name = "poll_answer_mail", length = 100, nullable = false, unique = true)
  private String mail;

  @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
  @JoinColumn(name = "music_genre_id", nullable = false)
  private JpaMusicGenre music_genre;
}