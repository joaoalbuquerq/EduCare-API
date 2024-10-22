package com.educare.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.dto.TurmaDTO;
import com.educare.api.entity.Turma;
import com.educare.api.repository.TurmaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repository;
	
	public Turma cadastrar(@Valid TurmaDTO dto) {
		return repository.save(new Turma(dto));
	}
	
	public List<Turma> listar(){
		return repository.findAll();
	}
	
	public Turma pesquisarPorId(Long id) {
		return repository.findById(id.intValue()).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public boolean deletar(Long id) {
		repository.delete(pesquisarPorId(id));
		return true;
		
	}

}
