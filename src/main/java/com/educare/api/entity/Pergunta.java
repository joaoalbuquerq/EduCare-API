package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.PerguntaDTO;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perguntas")
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String pergunta;
	//private Turma turma;
	private LocalDateTime dataCriacao;
	private LocalDateTime ultimaAlteracao;
	
	public Pergunta(PerguntaDTO dto) {
		this.dataCriacao = LocalDateTime.now();
		this.ultimaAlteracao = LocalDateTime.now();
		this.pergunta = dto.textoPergunta();
	}

}
