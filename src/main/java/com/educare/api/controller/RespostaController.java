package com.educare.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educare.api.dto.RespostaDTO;
import com.educare.api.entity.Resposta;
import com.educare.api.service.RespostaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
	
	@Autowired 
	RespostaService service;
	
	
	@PostMapping
	public ResponseEntity<Resposta> cadastrar(@RequestBody @Valid RespostaDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
	
	@GetMapping 
	public ResponseEntity<List<Resposta>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resposta> pesquisarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.pesquisarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
