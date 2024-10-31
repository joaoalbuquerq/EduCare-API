package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.RespostaDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "respostas")
public class Resposta {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "teste_id", nullable = false)
	private Teste teste;

	private String resposta;

	private LocalDateTime dataResposta;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;



	public Resposta(RespostaDTO dto) {
		this.dataResposta = LocalDateTime.now();
		this.dataCriacao= LocalDateTime.now();
		this.dataAtualizacao= LocalDateTime.now();
	}

	public Resposta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDateTime dataResposta) {
		this.dataResposta = dataResposta;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
