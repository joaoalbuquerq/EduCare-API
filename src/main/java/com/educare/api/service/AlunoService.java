package com.educare.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.AlunoDTO;
import com.educare.api.entity.Aluno;
import com.educare.api.repository.AlunoRepository;

import jakarta.validation.Valid;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository repository;

	public Aluno cadastrar(@Valid AlunoDTO dto) {
		return repository.save(new Aluno(dto));
	}

	public List<Aluno> listar() {
		return repository.findAll();
	}

	public Optional<Aluno> pesquisarPorId(Long id) {
		
		Optional<Aluno> aluno = repository.findById(id.intValue());

		return aluno;
		
	}

	public boolean deletar(Long id) {
		
		Optional<Aluno> aluno = pesquisarPorId(id);
		
		if(aluno.isPresent()) {
			repository.delete(aluno.get());
			return true;
		}else {
			return false;
		}
		
	}
	


}
