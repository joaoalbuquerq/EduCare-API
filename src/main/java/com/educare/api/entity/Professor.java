package com.educare.api.entity;

import java.time.LocalDateTime;

import com.educare.api.dto.AlunoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@Table(name = "professores")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private String email;
    private String senha;
    
    @OneToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Professor(AlunoDTO dto) {
		this.nome = dto.nome();
		this.senha = dto.senha();
		this.email = dto.email();
	}
}
