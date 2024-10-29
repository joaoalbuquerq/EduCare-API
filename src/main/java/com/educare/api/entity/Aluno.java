package com.educare.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.educare.api.dto.AlunoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "alunos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	//private Turma turma;
	private String escola;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	
	public Aluno(AlunoDTO dto) {
		this.nome = dto.nome();
		this.email = dto.email();
		this.dataNascimento = dto.dataNascimento();
		this.escola = dto.escola();
		this.dataAtualizacao = LocalDateTime.now();
		this.dataCriacao = LocalDateTime.now();
	}
}
