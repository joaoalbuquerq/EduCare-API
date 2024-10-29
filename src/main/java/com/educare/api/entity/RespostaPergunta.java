package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.PerguntaRespostaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respostas_perguntas")
public class RespostaPergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//private Resposta resposta;
	//private Pergunta pergunta;
	
	private LocalDateTime dataCriacao;
	private LocalDateTime ultimaAlteracao;
	
	
	public RespostaPergunta(PerguntaRespostaDTO dto) {
		
		//this.pergunta = dto.perguntaId();
		//this.resposta = dto.respostaId();
		this.dataCriacao = LocalDateTime.now();
		this.ultimaAlteracao = LocalDateTime.now();
	}

}
