package dev.wakandaacademy.wakanda.poc.video.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.wakanda.poc.video.domain.Video;
import lombok.Getter;

@Getter
public class VideoDTO {

	private Long id;
	private String titulo;
	private String descricao;
	private String url;

	public VideoDTO(Video video) {
		this.id = video.getId();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
	}

	public static List<VideoDTO> toList(List<Video> videos) {
		return videos.stream().map(VideoDTO::new).collect(Collectors.toList());
	}

}

//	DTO - Classe que irá definir quais campos serão retornados na exibição
//	(metodos GET), impedindo que acessemos os dados diretamente da entidade
// 
//
//	metodo que irá converter uma lista de Videos para uma lista de videoDTO 
//	(para a exibição de dados que queremos apresentar)
//	
//	public static List<VideoDTO> toList(List<Video> videos) {
//		return videos.stream().map(VideoDTO::new).collect(Collectors.toList());
//	}