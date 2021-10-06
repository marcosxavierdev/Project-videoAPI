package dev.wakandaacademy.wakanda.poc.video.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.wakanda.poc.video.domain.Video;

@Service
public interface VideoService {

	Video buscaVideoPorIdService(Long idVideo);

	Video adicionaVideoService(Video video);

	Video salvaVideoService(Video video);

	boolean existsByIdService(Long idVideo);

	void removeVideoService(Long idVideo);

	List<Video> listaVideosService();

}

/*
 * Interface que esta diretamente ligada com sua Service (sendo implementada em
 * VideoDataJpaService), sendo injetada na application/restController, para
 * oferecer metodos de persistencia (que podem aplicar regras de negocios) que
 * por suas vez recebem medotos da infrastructure que lidam diretamente com a
 * tecnologia de persistencia.
 */
