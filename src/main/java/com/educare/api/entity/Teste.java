package com.educare.api.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.educare.api.dto.TesteDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "testes")
public class Teste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;

	private LocalDateTime dataCriacao;
	private LocalDateTime ultimaAlteracao;
	
	public Teste(TesteDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao() != null ? dto.descricao() : "";
		this.dataCriacao = LocalDateTime.now();
		this.ultimaAlteracao = LocalDateTime.now();
	}

	@OneToMany(mappedBy = "teste", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pergunta> perguntas = new ArrayList<>();

	public void adicionarPergunta(Pergunta pergunta) {
		pergunta.setTeste(this);  // Define o teste na pergunta
		this.perguntas.add(pergunta);
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Teste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
}
