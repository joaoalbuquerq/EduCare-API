package com.educare.api.controller;

import java.util.List;

import com.educare.api.dto.ResponderTesteDTO;
import com.educare.api.dto.TesteComPerguntasERespostasDTO;
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

import com.educare.api.dto.TesteDTO;
import com.educare.api.entity.Teste;
import com.educare.api.service.TesteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@Autowired
	TesteService service;
	
	@PostMapping
	public ResponseEntity<Teste> cadastrar(@RequestBody @Valid TesteDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<Teste>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teste> pesquisarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.pesquisarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		if(service.deletar(id)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
		
	}

	@PostMapping("/{testeId}/responder")
	public ResponseEntity<String> responderTeste(
			@PathVariable Integer testeId,
			@RequestBody ResponderTesteDTO responderTesteDTO) {
			service.responderTeste(testeId, responderTesteDTO);
			return ResponseEntity.ok("Teste respondido com sucesso!");

	}

	@GetMapping("/{testeId}/alunos/{alunoId}/respostas")
	public ResponseEntity<?> obterRespostaTestePorAluno(@PathVariable Integer testeId, @PathVariable Integer alunoId) {
		TesteComPerguntasERespostasDTO testeDTO = service.getTesteComPerguntasERespostas(alunoId, testeId);
		return ResponseEntity.ok(testeDTO);
	}

}
