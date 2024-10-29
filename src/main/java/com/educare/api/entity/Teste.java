package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.TesteDTO;

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
	
}
