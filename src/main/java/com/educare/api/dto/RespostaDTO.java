package com.educare.api.dto;

import jakarta.validation.constraints.NotNull;

public record RespostaDTO(
		@NotNull
		Integer alunoId,
		
		@NotNull
		Integer testeId
		){

}
