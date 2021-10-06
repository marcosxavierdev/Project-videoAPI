package dev.wakandaacademy.wakanda.poc.video.application.api;

import dev.wakandaacademy.wakanda.poc.video.domain.Video;
import lombok.Getter;

@Getter
public class VideoFORM {

	private long id;
	private String titulo;
	private String descricao;
	private String url;

	public Video toEntity() {
		return new Video(id, titulo, descricao, url);
	}

}

//	FORM - Classe que define os dados que serão recebidos numa entrada de dados do sistema,
//	para que não possamos estar trabalhando diretamente com a entidade
//
//
//	/* metodo que irá converter o Videoform em um Video(entidade)*/
//
//	public Video toEntity() {
//		return new Video(id, titulo, descricao, url);
//	}

//	/* metodo que irá converter o Videoform em um Video(entidade)*/
//	Alternativa by Wakanda
//	public Video toEntity () {
//		return Video.builder().id(id).titulo(titulo).descricao(descricao).url(url).build();
//	}
