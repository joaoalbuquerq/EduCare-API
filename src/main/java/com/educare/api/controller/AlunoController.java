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

import com.educare.api.dto.AlunoDTO;
import com.educare.api.entity.Aluno;
import com.educare.api.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService service;
	
	@PostMapping
	public ResponseEntity<Aluno> cadastrar(@RequestBody @Valid AlunoDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> pesquisarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.pesquisarPorId(id));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagar(@PathVariable Long id) {
		boolean sucesso = service.deletar(id);
		if(sucesso) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
