package cl.bglm.exams.threeit.musicpollbackend.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity class for poll answers.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "poll_answers")
public class JpaPollAnswer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "poll_answer_id", nullable = false)
  @Getter @Setter
  private Long id;

  @Column(name = "poll_answer_mail", length = 100, nullable = false)
  @Getter @Setter
  private String mail;

  @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
  @JoinColumn(name = "music_genre_id", nullable = false)
  @Getter @Setter
  private JpaMusicGenre music_genre;
}