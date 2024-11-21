package com.educare.api.dto;

import jakarta.validation.constraints.*;

public record ProfessorDTO(
    @NotBlank String nome,
    @Email String email,
    @NotBlank String senha
){}