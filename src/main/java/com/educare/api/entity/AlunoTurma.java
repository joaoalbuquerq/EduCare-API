package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.AlunoTurmaDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AlunoTurma {
	
	private Integer id;
	//private Aluno aluno;
	//private Turma turma;
	private LocalDateTime dataCriacao;
	private LocalDateTime ultimaAlteracao;
	
	public AlunoTurma(AlunoTurmaDTO dto) {
		//this.aluno = dto.alunoId;
		//this.turma = dto.turmaId;
		this.dataCriacao = LocalDateTime.now();
		this.ultimaAlteracao = LocalDateTime.now();
	}

}
