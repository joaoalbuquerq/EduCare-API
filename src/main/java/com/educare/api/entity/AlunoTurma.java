package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.AlunoTurmaDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "alunos_turmas")
@Entity
public class AlunoTurma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "turma_id", nullable = false)
	private Turma turma;

	private LocalDateTime dataCriacao;
	private LocalDateTime ultimaAlteracao;

	public AlunoTurma(AlunoTurmaDTO dto) {
		//this.aluno = dto.alunoId;
		//this.turma = dto.turmaId;
		this.dataCriacao = LocalDateTime.now();
		this.ultimaAlteracao = LocalDateTime.now();
	}

	public AlunoTurma() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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
