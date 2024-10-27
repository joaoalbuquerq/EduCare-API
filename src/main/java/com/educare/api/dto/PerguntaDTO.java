package com.educare.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PerguntaDTO(
		@NotNull
		Integer testeId,
		
		@NotBlank
		String textoPergunta
		) {

}
