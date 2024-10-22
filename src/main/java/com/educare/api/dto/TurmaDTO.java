package com.educare.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TurmaDTO(
		@NotBlank
		String nome,
		@NotBlank
		String escola
		) {

}
