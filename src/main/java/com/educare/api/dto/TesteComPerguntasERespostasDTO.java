package com.educare.api.dto;

import java.util.List;

public record TesteComPerguntasERespostasDTO(
        Integer testeId,
        String nomeTeste,
        String descricao,
        List<PerguntaComRespostaDTO> perguntas
) {
}
