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

import com.educare.api.dto.TurmaDTO;
import com.educare.api.entity.Turma;
import com.educare.api.service.TurmaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaService service;
	
	@PostMapping
	public ResponseEntity<Turma> cadastrar(@RequestBody @Valid TurmaDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<Turma>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> pesquisarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.pesquisarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		if(!service.deletar(id)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}

}
