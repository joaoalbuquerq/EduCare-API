package com.educare.api.dto;

import java.util.Map;

public record ResponderTesteDTO (
        Integer alunoId,
        Integer testeId,
        Map<Integer, String> respostas
){
}
