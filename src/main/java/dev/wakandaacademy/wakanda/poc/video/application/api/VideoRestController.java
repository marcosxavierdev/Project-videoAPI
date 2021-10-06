package dev.wakandaacademy.wakanda.poc.video.application.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.wakandaacademy.wakanda.poc.video.application.service.VideoService;
import dev.wakandaacademy.wakanda.poc.video.domain.Video;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
public class VideoRestController implements VideoAPI {
	private VideoService videoService;

	@Override
	public VideoDTO buscaVideoPorId(Long idVideo) {
		log.info("[Iniciando] - Método buscaVideoPorId em VideoRestController");
		Video video = videoService.buscaVideoPorIdService(idVideo);
		log.info("[Finalizando] - Metodo buscaVideoPorId em VideoRestController");
		return new VideoDTO(video);
	}

	@Override
	public ResponseEntity<VideoDTO> adicionaVideo(VideoFORM videoForm, UriComponentsBuilder uriBuilder) {
		log.info("[Iniciando] - Método adicionaVideo em VideoRestController");
		Video video = videoService.adicionaVideoService(videoForm.toEntity());
		URI uri = uriBuilder.path("/").buildAndExpand(video.getId()).toUri();
		log.info("[Finalizando] - Método adicionaVideo em VideoRestController");
		return ResponseEntity.created(uri).body(new VideoDTO(video));
	}

	@Override
	public ResponseEntity<Video> editaVideo(Long idVideo, Video video) {
		log.info("[Iniciando] - Método editaVideo em VideoRestController");
		if (!videoService.existsByIdService(idVideo)) {
			return ResponseEntity.notFound().build();
		}
		video.setId(idVideo);
		video = videoService.adicionaVideoService(video);
		log.info("[Finalizando] - Método editaVideo em VideoRestController");
		return ResponseEntity.ok(video);
	}

	public ResponseEntity<Void> deletaVideo(@PathVariable Long idVideo) {
		log.info("[Iniciando] - Método deletaVideo em VideoRestController");
		if (!videoService.existsByIdService(idVideo)) {
			return ResponseEntity.notFound().build();
		}
		videoService.removeVideoService(idVideo);
		log.info("[Finalizando] - Método deletaVideo em VideoRestController");
		return ResponseEntity.noContent().build();
	}

	@Override
	public List<VideoDTO> listaVideos() {
		List<Video> videos = videoService.listaVideosService();
		return VideoDTO.toList(videos);
	}

	@Override
	public String working() {
		return "working";
	}

}

//	private VideoService videoService; 
//	/*injetamos a interface do service para buscar os metodos da classe service*/
//
//	/* metodo GET que busca um video por id */
//
//	@Override
//	public VideoDTO buscaVideoPorId(Long idVideo) { 
//	/*precisamos retornar um DTO, passando a id do video como parametro*/
//		
//		log.info("[Iniciando] - Método buscaVideoPorId em VideoRestController");
//		
//		Video video = videoService.buscaVideoPorIdService(idVideo); 
//		/*chamamos o metodo da service*/
//		
//		log.info("[Finalizando] - Metodo buscaVideoPorId em VideoRestController");
//		
//		return new VideoDTO(video); 
//		/*criamos um novo DTO com os dados do video temos como retorno do metodo acima*/
//	}
//
//	/* metodo POST que inclui um video */
//
//	@Override
//	public ResponseEntity<VideoDTO> adicionaVideo(VideoFORM videoForm, UriComponentsBuilder uriBuilder) {
//	/*precisamos retornar um ResponseEntity de um DTO no response (para mostrar no body), recebendo um FORM e um UriBuilder como parametros
//	* o FORM será a inclusão dos dados para a entrada de dados e a UriBuilder fará a construção da URL personalizada*/
//		
//		log.info("[Iniciando] - Método adicionaVideo em VideoRestController");
//		
//		Video video = videoService.adicionaVideoService(videoForm.toEntity());
//		/*chamamos o metodo da service, passando o form convertido em entidade*/
//		
//		URI uri = uriBuilder.path("/").buildAndExpand(video.getId()).toUri(); 
//		/*criamos a URI, capturando o caminho, o parametro e no final convertemos tudo na uri final*/
//		
//		log.info("[Finalizando] - Método adicionaVideo em VideoRestController");
//		
//		return ResponseEntity.created(uri).body(new VideoDTO(video)); 
//		/*retornamos uma responseEntity, com status 201 e com um novo DTO para ser visualizado no body*/
//	}
//
//	/* metodo PUT que atualiza um video por id */
//
//	@Override
//	public ResponseEntity<Video> editaVideo(Long idVideo, Video video) {
//	/*precisamos retornar ResponseEntity de um Video (para ser gravado novamente no banco de dados) recebendo o id e o video que será editado*/
//		
//		log.info("[Iniciando] - Método editaVideo em VideoRestController");
//		
//		if (!videoService.existsByIdService(idVideo)) { 
//			return ResponseEntity.notFound().build(); 
//		} 
//		/*se o id do video não existir ou não for encontrado no banco de dados*/
//		/*irá retornar um 404 (não devolvendo nada no body, o build constroi um retorno vazio)*/
//		/*se o id do video existir no banco de dados*/
//		
//		video.setId(idVideo); 
//		/*vai buscar o video por aquele id e fazer a alteração de acordo com o que foi passado*/
//		
//		video = videoService.adicionaVideoService(video); 
//		/*chama o metodo no service para para persistir a ação, no caso alterar o registro*/
//		
//		log.info("[Finalizando] - Método editaVideo em VideoRestController");
//		
//		return ResponseEntity.ok(video); 
//		/*retornando um status ok, confirmando a alteração*/
//	}
//
//	/* metodo DELETE que deleta um video por id */
//
//	public ResponseEntity<Void> deletaVideo(@PathVariable Long idVideo) { 
//	/*precisamos retornar um ResponseEntity sem valor recebendo o id do video que será deletado*/
//		
//		log.info("[Iniciando] - Método deletaVideo em VideoRestController");
//		
//		if (!videoService.existsByIdService(idVideo)) {
//			return ResponseEntity.notFound().build();
//		} 
//		/*se o id do video não existir ou não for encontrado no banco de dados*/
//		/*irá retornar um 404 (não devolvendo nada no body, o build constroi um retorno vazio*/
//		/*se o id do video existir no banco de dados*/
//		
//		videoService.removeVideoService(idVideo); 
//		/*chama o metodo no service para para persistir a ação, no caso apagar o registro*/
//		
//		log.info("[Finalizando] - Método deletaVideo em VideoRestController");
//		
//		return ResponseEntity.noContent().build(); 
//		/*retornando um status No content (sem conteudo algum) e (não devolvendo nada no body, o build constroi um retorno vazio)*/
//	}
//
//	/* metodo GET que busca todos os videos */
//
//	@Override
//	public List<VideoDTO> listaVideos() { 		
//	/*precisamos retornar uma lista de DTOs*/
//
//		List<Video> videos = videoService.listaVideosService();
//		/*precisamos buscar uma lista de registro na entiade, essa lista de videos vai buscar todos os registros persistidos no banco de dados*/
//		
//		return VideoDTO.toList(videos);
//		/*como queremos retonar uma lista de DTOs e não entidades, convertemos a mesma em DTO*/
//	}
//
//	/*metodo simples so para testar o mapeamento no postman*/
//	@Override
//	public String working() {
//		return "working"; 
//		/*retornando uma string para confirmar resposta no body do postman*/
//	}
