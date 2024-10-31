package com.educare.api.service;

import java.util.List;

import com.educare.api.entity.Teste;
import com.educare.api.repository.TesteRepository;
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

	@Autowired
	TesteRepository testeRepository;
	
	public Pergunta cadastrar(PerguntaDTO dto) {

		Teste teste = testeRepository.findById(dto.testeId())
				.orElseThrow(() -> new EntityNotFoundException("Teste não encontrado"));

		Pergunta novaPergunta = new Pergunta(dto);

		// Adiciona a pergunta ao teste, sincronizando ambos os lados
		teste.adicionarPergunta(novaPergunta);

		repository.save(novaPergunta);

		// Salva e sincroniza toda a entidade Teste com a nova pergunta
		testeRepository.save(teste);

		return pesquisarPorId(novaPergunta.getId().longValue());
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
