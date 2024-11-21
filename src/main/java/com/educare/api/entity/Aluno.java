package com.educare.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.educare.api.dto.AlunoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "alunos")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "aluno")
	private List<Resposta> respostas;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;

	private String escola;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	
	public Aluno(AlunoDTO dto) {
		this.nome = dto.nome();
		this.senha = dto.senha();
		this.email = dto.email();
		this.dataNascimento = dto.dataNascimento();
		this.escola = dto.escola();
		this.dataAtualizacao = LocalDateTime.now();
		this.dataCriacao = LocalDateTime.now();
	}

	

	public Aluno() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
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

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
