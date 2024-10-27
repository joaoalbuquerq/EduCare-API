package com.educare.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.dto.PerguntaDTO;
import com.educare.api.entity.Pergunta;
import com.educare.api.repository.PerguntaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PerguntaService {
	
	@Autowired
	PerguntaRepository repository;
	
	public Pergunta cadastrar(PerguntaDTO dto) {
		return repository.save(new Pergunta(dto));
	}
	
	public List<Pergunta> listar(){
		return repository.findAll();
	}
	
	public Pergunta pesquisarPorId(Long id) {
		return repository.findById(id.intValue()).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public boolean deletar(Long id) {
		repository.delete(pesquisarPorId(id));
		return true;
	}

}
