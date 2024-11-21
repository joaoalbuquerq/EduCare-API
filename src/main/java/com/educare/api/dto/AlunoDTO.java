package com.educare.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record AlunoDTO(
		@NotBlank String nome,
		@Email String email,	
		@Past LocalDate dataNascimento,
		@NotBlank String escola,
		@NotNull Integer turmaId,
		@NotBlank String senha
){}
