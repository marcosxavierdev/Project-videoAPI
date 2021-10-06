package dev.wakandaacademy.wakanda.poc.video.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.wakanda.poc.video.domain.Video;

@Repository
public interface VideoRepository {
	Optional<Video> buscaVideoPorIdInfra(Long idVideo);

	Video adicionaVideoInfra(Video video);

	boolean existsByIdInfra(Long idVideo);

	void removeVideoInfra(Long idVideo);

	List<Video> listaVideosInfra();
}

/*
 * Interface que esta diretamente ligada com a infrastructure (sendo
 * implementada em VideoJpaRepository), sendo injetada na application/Service
 * (pois ela que vai buscar os metodos da VideoJpaRepository que implementam os
 * metodos da tecnologia de persistencia utilizada no projeto)
 */
