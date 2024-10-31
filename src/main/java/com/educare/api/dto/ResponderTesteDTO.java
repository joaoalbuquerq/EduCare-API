package com.educare.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

public record ResponderTesteDTO(
        @NotNull
        Integer alunoId,
        @NotNull @NotBlank
        List<PerguntaRespostaDTO> respostas
) {
    public record PerguntaRespostaDTO(
            @NotNull
            Integer perguntaId,
            @NotBlank
            String resposta
    ) {}
}
