package com.educare.api.dto;

public record PerguntaComRespostaDTO(
        Integer perguntaId,
        String textoPergunta,
        String respostaAluno
) {
}
