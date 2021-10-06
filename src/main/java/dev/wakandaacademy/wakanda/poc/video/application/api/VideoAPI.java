package dev.wakandaacademy.wakanda.poc.video.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.wakandaacademy.wakanda.poc.video.domain.Video;

@RestController
@RequestMapping("/v1/video")
public interface VideoAPI {

	/* metodo que retornara um registro, usando seu id como parametro */

	@GetMapping("/{idVideo}")
	@ResponseStatus(value = HttpStatus.OK) /* com o metodo executado, retornara status 200 (OK) */
	VideoDTO buscaVideoPorId(@PathVariable Long idVideo);

	/* metodo que adicionará um registro */
	@PostMapping("/adicionaVideo")
	@ResponseStatus(value = HttpStatus.CREATED) /* com o metodo executado, retornara status 201 (CREATED) */
	ResponseEntity<VideoDTO> adicionaVideo(@RequestBody VideoFORM videoForm, UriComponentsBuilder uriBuilder);

	/* metodo que irá atualizar um registro, usando seu id como parametro */
	@PutMapping("/editaVideo/{idVideo}")
	@ResponseStatus(value = HttpStatus.OK) /* com o metodo executado, retornara status 200 (OK) */
	ResponseEntity<Video> editaVideo(@PathVariable Long idVideo, @RequestBody Video video);

	/* metodo que irá deletar um registro,usando seu id como parametro */
	@DeleteMapping("/deletaVideo/{idVideo}")
	ResponseEntity<Void> deletaVideo(@PathVariable Long idVideo);

	/* metodo que retornara todos os itens cadastrados no banco de dados */
	@GetMapping("/listaVideos")
	public List<VideoDTO> listaVideos();

	/* metodo de teste do mapeamento */
	@GetMapping("/working")
	@ResponseStatus(value = HttpStatus.OK)
	String working();

}

/*
 * Interface da aplicação, que está definindo os métodos que serão implementados
 * no controller (VideoRestController) já com algumas especificações
 * incorporadas (que não será necessário expressar lá, tornando o código mais
 * legível no controller).
 */
