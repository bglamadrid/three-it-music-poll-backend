package cl.bglm.exams.threeit.musicpollbackend;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"cl.bglm.exams.threeit.musicpollbackend.jpa.entities"})
@EnableJpaRepositories(basePackages = {"cl.bglm.exams.threeit.musicpollbackend.jpa.repositories"})
public class MusicPollBackendJpaConfig {
}
