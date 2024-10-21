package com.educare.api;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record AlunoDTO(
		@NotBlank
		String nome,
		
		String email,
		
		@NotBlank
		LocalDate dataNascimento,
		
		@NotBlank
		String escola
		){

}
