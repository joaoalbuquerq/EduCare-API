package com.educare.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.dto.TesteDTO;
import com.educare.api.entity.Teste;
import com.educare.api.repository.TesteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TesteService {

	@Autowired
	TesteRepository repository;
	
	public Teste cadastrar(TesteDTO dto) {
		return repository.save(new Teste(dto));
	}
	
	public List<Teste> listar(){
		return repository.findAll();	
	}
	
	public Teste pesquisarPorId(Long id) {
		return repository.findById(id.intValue()).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public boolean deletar(Long id) {
		repository.delete(pesquisarPorId(id));
		return true;
	}
}
