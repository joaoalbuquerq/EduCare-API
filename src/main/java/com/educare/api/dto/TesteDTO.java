package com.educare.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TesteDTO(
		@NotBlank
		String nome,
		String descricao
) {

}
