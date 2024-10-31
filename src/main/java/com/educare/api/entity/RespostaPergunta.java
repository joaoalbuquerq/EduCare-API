package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.PerguntaRespostaDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "respostas_perguntas")
public class RespostaPergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "resposta_id", nullable = false)
	private Resposta resposta;

	@ManyToOne
	@JoinColumn(name = "pergunta_id", nullable = false)
	private Pergunta pergunta;
	
	private LocalDateTime dataCriacao;
	private LocalDateTime ultimaAlteracao;
	
	
	public RespostaPergunta(PerguntaRespostaDTO dto) {
		
		//this.pergunta = dto.perguntaId();
		//this.resposta = dto.respostaId();
		this.dataCriacao = LocalDateTime.now();
		this.ultimaAlteracao = LocalDateTime.now();
	}

	public RespostaPergunta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(LocalDateTime ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
