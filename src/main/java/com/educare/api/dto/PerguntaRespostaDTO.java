package com.educare.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PerguntaRespostaDTO(
		@NotNull
		Integer perguntaId,
		@NotBlank
		String resposta
		) {

}
