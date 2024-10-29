package com.educare.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.educare.api.dto.DadosErroValidacaoDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorErrosController {
	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarErro404(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacaoDTO::new).toList());
    }

}
