package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.RespostaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resposta {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	//private Aluno aluno;
	//private Teste teste;
	private LocalDateTime dataResposta;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;

	public Resposta(RespostaDTO dto) {
		this.dataResposta = LocalDateTime.now();
		this.dataCriacao= LocalDateTime.now();
		this.dataAtualizacao= LocalDateTime.now();
	}
}
