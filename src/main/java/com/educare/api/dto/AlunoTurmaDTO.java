package com.educare.api.dto;

import jakarta.validation.constraints.NotNull;

public record AlunoTurmaDTO(
		@NotNull
		Integer alunoId,
		
		@NotNull
		Integer turmaId
		) {

}
