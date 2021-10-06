package dev.wakandaacademy.wakanda.poc.video.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.wakanda.poc.video.domain.Video;

@Repository
public interface VideoSpringDataJpaRepository extends JpaRepository<Video, Long> {
	Optional<Video> findById(Long idVideo);

	boolean existsById(Long idVideo);

}

/*
 * Interface que esta diretamente ligada com a tecnologia de persistencia (do
 * banco de dados) sendo injetada na classe VideoJpaRepository da
 * infrastructure, para que a mesma acesse os metodos diretamente da tecnologia
 * para fornecer ao service novos metodos de persistencia diminuindo assim o
 * acoplamento e dependencia entre classes.
 */