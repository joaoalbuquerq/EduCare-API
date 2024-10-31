package com.educare.api.service;

import java.util.List;
import java.util.Optional;

import com.educare.api.entity.Turma;
import com.educare.api.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.dto.AlunoDTO;
import com.educare.api.entity.Aluno;
import com.educare.api.repository.AlunoRepository;

import jakarta.validation.Valid;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository repository;

	@Autowired
	TurmaRepository turmaRepository;

	public Aluno cadastrar(@Valid AlunoDTO dto) {
		var aluno = new Aluno(dto);

		if (dto.turmaId() != null) {
			aluno.setTurma(turmaRepository.findById(dto.turmaId()).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada")));
		}
		repository.save(aluno);
		
		return aluno;
	}



	public List<Aluno> listar() {
		return repository.findAll();
	}

	public Aluno pesquisarPorId(Long id) {
		return repository.findById(id.intValue()).orElseThrow( () -> new EntityNotFoundException());
		
	}

	public boolean deletar(Long id) {
		repository.delete(pesquisarPorId(id));
		return true;
	}
	


}
