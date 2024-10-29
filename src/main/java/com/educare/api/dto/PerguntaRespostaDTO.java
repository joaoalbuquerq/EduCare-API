package com.educare.api.dto;

import jakarta.validation.constraints.NotNull;

public record PerguntaRespostaDTO(
		@NotNull
		Integer respostaId,
		@NotNull
		Integer perguntaId
		) {

}
