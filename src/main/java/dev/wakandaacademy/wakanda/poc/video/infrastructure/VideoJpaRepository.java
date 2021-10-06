package dev.wakandaacademy.wakanda.poc.video.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.wakandaacademy.wakanda.poc.video.application.repository.VideoRepository;
import dev.wakandaacademy.wakanda.poc.video.domain.Video;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class VideoJpaRepository implements VideoRepository {
	private VideoSpringDataJpaRepository videoSpringDataJpaRepository;

	@Override
	public Optional<Video> buscaVideoPorIdInfra(Long idVideoService) {
		log.info("[Iniciando] - Método buscaVideoInfra em VideoJpaRepository");
		Optional<Video> buscaVideoPorId = videoSpringDataJpaRepository.findById(idVideoService);
		log.info("[Finalizando] - Método buscaVideoInfra em VideoJpaRepository");
		return buscaVideoPorId;
	}

	@Override
	public Video adicionaVideoInfra(Video videoService) {
		log.info("[Iniciando] - Método salvaVideoInfra em VideoJpaRepository");
		Video novoVideo = videoSpringDataJpaRepository.save(videoService);
		log.info("[Finalizando] - Método salvaVideoInfra em VideoJpaRepository");
		return novoVideo;
	}

	@Override
	public boolean existsByIdInfra(Long idVideoService) {
		log.info("[Iniciando] - Método verificaVideoInfra em VideoJpaRepository");
		boolean video = videoSpringDataJpaRepository.existsById(idVideoService);
		log.info("[Finalizando] - Método verificaVideoInfra em VideoJpaRepository");
		return video;
	}

	@Override
	public void removeVideoInfra(Long idVideoService) {
		log.info("[Iniciando] - Método deleteByIdInfra em VideoJpaRepository");
		videoSpringDataJpaRepository.deleteById(idVideoService);
		log.info("[Finalizando] - Método deleteByIdInfra em VideoJpaRepository");

	}

	@Override
	public List<Video> listaVideosInfra() {
		return videoSpringDataJpaRepository.findAll();
	}

}

//	private VideoSpringDataJpaRepository videoSpringDataJpaRepository; 
//	/*injetamos a interface da infrastructure para acessar os metodos diretamente da tecnologia de persistencia utilizada no projeto (no caso um sql H2)*/
//	
//	@Override
//	public Optional<Video> buscaVideoPorIdInfra(Long idVideoService) {
//		/*precisamos retornar um Optional video, recebendo a id do video (que vem do service => que veio do controller)) como parametro*/
//		
//		log.info("[Iniciando] - Método buscaVideoInfra em VideoJpaRepository");
//		
//		Optional<Video> buscaVideoPorId = videoSpringDataJpaRepository.findById(idVideoService);
//		/*chamamos o metodo da tecnologia passando o id do video (que vem do service => que veio do controller) como parametro*/
//		
//		log.info("[Finalizando] - Método buscaVideoInfra em VideoJpaRepository");
//		
//		return buscaVideoPorId; 
//		/*retornamos para as camadas acima (service e depois controller) o resultado do findById da tecnologia de persistencia*/
//	}
//	
//	@Override
//	public Video adicionaVideoInfra(Video videoService) {
//		/*precisamos retornar um video, recebendo o video (que vem do service => que veio do controller)) como parametro*/
//		
//		log.info("[Iniciando] - Método salvaVideoInfra em VideoJpaRepository");
//		
//		Video novoVideo = videoSpringDataJpaRepository.save(videoService);
//		/*chamamos o metodo da tecnologia passando o video (que vem do service => que veio do controller) como parametro*/
//		
//		log.info("[Finalizando] - Método salvaVideoInfra em VideoJpaRepository");
//		
//		return novoVideo;
//		/*retornamos para as camadas acima (service e depois controller) o resultado do save da tecnologia de persistencia*/
//	}
//	
//	@Override
//	public boolean existsByIdInfra(Long idVideoService) {
//		/*precisamos retornar um boolean, recebendo a id do video (que vem do service => que veio do controller)) como parametro*/
//		
//		log.info("[Iniciando] - Método verificaVideoInfra em VideoJpaRepository");
//		
//		boolean video = videoSpringDataJpaRepository.existsById(idVideoService);
//		/*chamamos o metodo da tecnologia passando o id do video (que vem do service => que veio do controller) como parametro*/
//		
//		log.info("[Finalizando] - Método verificaVideoInfra em VideoJpaRepository");
//		
//		return video;
//		/*retornamos para as camadas acima (service e depois controller) o resultado do existsById da tecnologia de persistencia*/
//	}
//	
//	@Override
//	public void removeVideoInfra(Long idVideoService) {
//		/*recebemos a id do video (que vem do service => que veio do controller)) como parametro*/
//		
//		log.info("[Iniciando] - Método deleteByIdInfra em VideoJpaRepository");
//		
//		videoSpringDataJpaRepository.deleteById(idVideoService); 
//		/*chamamos o metodo da tecnologia passando o id do video (que vem do service => que veio do controller) como parametro*/
//		
//		log.info("[Finalizando] - Método deleteByIdInfra em VideoJpaRepository");
//		/*retornamos para as camadas acima (service e depois controller) o resultado do deleteById da tecnologia de persistencia*/
//	}
//	
//	@Override
//	public List<Video> listaVideosInfra() {
//		/*precisamos retornar uma lista de videos com todos os videos registrados no banco de dados*/
//		
//		return videoSpringDataJpaRepository.findAll();
//		/*retornamos para as camadas acima (service e depois controller) o resultado do findAll da tecnologia de persistencia*/
//	}
