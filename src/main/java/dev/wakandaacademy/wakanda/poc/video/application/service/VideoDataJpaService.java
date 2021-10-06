package dev.wakandaacademy.wakanda.poc.video.application.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.wakanda.handler.ApiException;
import dev.wakandaacademy.wakanda.poc.video.application.repository.VideoRepository;
import dev.wakandaacademy.wakanda.poc.video.domain.Video;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class VideoDataJpaService implements VideoService {
	private VideoRepository videoRepository;

	@Override
	public Video buscaVideoPorIdService(Long idVideoController) {
		log.info("[Iniciando] - Método buscaVideoPorId em VideoDataJpaService");
		Video videoPorId = videoRepository.buscaVideoPorIdInfra(idVideoController)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Video não encontrado!"));
		log.info("[Finalizando] - Método buscaVideoPorId em VideoDataJpaService");
		return videoPorId;
	}

	@Override
	public Video adicionaVideoService(Video videoController) {
		log.info("[Iniciando] - Método adicionaVideo em VideoDataJpaService");
		Video novoVideo = videoRepository.adicionaVideoInfra(videoController);
		log.info("[Finalizando] - Método adicionaVideo em VideoDataJpaService");
		return novoVideo;
	}

	@Override
	public Video salvaVideoService(Video videoController) {
		log.info("[Iniciando] - Método salvaVideoService em VideoDataJpaService");
		Video novoVideo = videoRepository.adicionaVideoInfra(videoController);
		log.info("[Finalizando] - Método salvaVideoService em VideoDataJpaService");
		return novoVideo;
	}

	@Override
	public boolean existsByIdService(Long idVideoController) {
		log.info("[Iniciando] - Método existsByIdService em VideoDataJpaService");
		boolean statusVideo = videoRepository.existsByIdInfra(idVideoController);
		log.info("[Finalizando] - Método existsByIdService em VideoDataJpaService");
		return statusVideo;
	}

	@Override
	public void removeVideoService(Long idVideoController) {
		log.info("[Iniciando] - Método removeVideoService em VideoDataJpaService");
		videoRepository.removeVideoInfra(idVideoController);
		log.info("[Finalizando] - Método removeVideoService em VideoDataJpaService");
	}

	@Override
	public List<Video> listaVideosService() {
		return videoRepository.listaVideosInfra();
	}

}

//	private VideoRepository videoRepository; /*injetamos a interface da application/Repository para buscar os metodos da classe infrastructure*/
//
//	@Override
//	public Video buscaVideoPorIdService(Long idVideoController) {
//	/*precisamos retornar um video, recebendo a id do video (que vem do controller) como parametro*/
//
//	log.info("[Iniciando] - Método buscaVideoPorId em VideoDataJpaService");
//
//	Video videoPorId = videoRepository.buscaVideoPorIdInfra(idVideoController)
//			.orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Video não encontrado!")); 
//	/*chamamos o metodo da infra que recebe o id do video (que vem do controller) como parametro, e se o valor estiver presente, 
//	retorna o valor, caso contrário, lança a exceção informada no parâmetro (não encontrado e string comtexto).*/
//
//	log.info("[Finalizando] - Método buscaVideoPorId em VideoDataJpaService");
//
//	return videoPorId; 
//	/* retorna o novo video que recebeu os dados do metodo acima */
//	}
//
//	@Override
//	public Video adicionaVideoService(Video videoController) {
//	/*precisamos retornar um video, recebendo um objeto video (que vem do controller) como parametro*/
//
//	log.info("[Iniciando] - Método adicionaVideo em VideoDataJpaService");
//
//	Video novoVideo = videoRepository.adicionaVideoInfra(videoController); 
//	/* chamamos o metodo da infra que recebe o video (que vem do controller) como parametro*/
//
//	log.info("[Finalizando] - Método adicionaVideo em VideoDataJpaService");
//
//	return novoVideo; 
//	/*retorna o novo video que recebeu os dados do metodo acima*/
//	}
//
//	@Override
//	public Video salvaVideoService(Video videoController) {
//	/*precisamos retornar um video, recebendo um objeto video (que vem do controller) como parametro*/
//
//	log.info("[Iniciando] - Método salvaVideoService em VideoDataJpaService");
//
//	Video novoVideo = videoRepository.adicionaVideoInfra(videoController); 
//	/*chamamos o metodo da infra que recebe o video (que vem do controller) como parametro*/
//
//	log.info("[Finalizando] - Método salvaVideoService em VideoDataJpaService");
//
//	return novoVideo; 
//	/*retorna o novo video que recebeu os dados do metodo acima*/
//	}
//
//	@Override
//	public boolean existsByIdService(Long idVideoController) {
//	/*precisamos retornar um booleano, recebendo a id do video (que vem do controller) como parametro*/
//
//	log.info("[Iniciando] - Método existsByIdService em VideoDataJpaService");
//
//	boolean statusVideo = videoRepository.existsByIdInfra(idVideoController); 
//	/*retorna positivo se o id encontra-se registrado no banco de dados*/
//
//	log.info("[Finalizando] - Método existsByIdService em VideoDataJpaService");
//
//	return statusVideo; 
//	/*retorna o status do video que recebeu os dados do metodo acima*/
//	}
//
//	@Override
//	public void removeVideoService(Long idVideoController) {
//	/*metodo sem retorno (void) que recebe o id do video (que vem do controller) como parametro*/
//
//	log.info("[Iniciando] - Método removeVideoService em VideoDataJpaService");
//
//	videoRepository.removeVideoInfra(idVideoController); 
//	/*remove o banco de dados o registro o qual teve seu id passado como parametro*/
//
//	log.info("[Finalizando] - Método removeVideoService em VideoDataJpaService");
//	}
//
//	@Override
//	public List<Video> listaVideosService() {
//	/*precisamos retornar uma lista de videos*/
//
//		return videoRepository.listaVideosInfra();
//		/*retornando uma lista com todos os videos do banco de dados*/
//	}
