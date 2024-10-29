package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.TurmaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turmas")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String escola;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	
	public Turma(TurmaDTO dto) {
		this.nome = dto.nome();
		this.escola = dto.escola();
		this.dataCriacao = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}

}
