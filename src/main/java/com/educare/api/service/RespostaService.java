package com.educare.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.dto.RespostaDTO;
import com.educare.api.entity.Resposta;
import com.educare.api.repository.RespostaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RespostaService {

	@Autowired
	RespostaRepository repository;
	
	public Resposta cadastrar(RespostaDTO dto) {
		return repository.save(new Resposta(dto));
	}

	public Resposta cadastrarAtualizar(Resposta resposta){
		return repository.save(resposta);
	}
	
	public List<Resposta> listar(){
		return repository.findAll();
	}
	
	public Resposta pesquisarPorId(Long id) {
		return repository.findById(id.intValue()).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public boolean deletar(Long id) {
		repository.delete(pesquisarPorId(id));
		return true;
	}

}
