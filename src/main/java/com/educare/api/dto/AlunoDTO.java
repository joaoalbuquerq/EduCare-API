package com.educare.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record AlunoDTO(
		@NotBlank
		String nome,
		
		String email,
		
		@Past
		LocalDate dataNascimento,
		
		@NotBlank
		String escola
		){

}
