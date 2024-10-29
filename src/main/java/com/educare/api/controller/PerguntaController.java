package com.educare.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educare.api.dto.PerguntaDTO;
import com.educare.api.entity.Pergunta;
import com.educare.api.service.PerguntaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

	@Autowired
	PerguntaService service;
	
	
	@PostMapping
	public ResponseEntity<Pergunta> cadastrar(@RequestBody @Valid PerguntaDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<Pergunta>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> pesquisarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.pesquisarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}
