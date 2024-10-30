package com.educare.api.service;

import java.time.LocalDateTime;
import java.util.List;

import com.educare.api.dto.ResponderTesteDTO;
import com.educare.api.entity.Aluno;
import com.educare.api.entity.Pergunta;
import com.educare.api.entity.Resposta;
import com.educare.api.repository.AlunoRepository;
import com.educare.api.repository.PerguntaRepository;
import com.educare.api.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.api.dto.TesteDTO;
import com.educare.api.entity.Teste;
import com.educare.api.repository.TesteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TesteService {

	@Autowired
	TesteRepository testeRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	PerguntaRepository perguntaRepository;

	@Autowired
	RespostaRepository respostaRepository;


	
	public Teste cadastrar(TesteDTO dto) {
		return testeRepository.save(new Teste(dto));
	}
	
	public List<Teste> listar(){
		return testeRepository.findAll();
	}
	
	public Teste pesquisarPorId(Long id) {
		return testeRepository.findById(id.intValue()).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public boolean deletar(Long id) {
		testeRepository.delete(pesquisarPorId(id));
		return true;
	}

	public void responderTeste(ResponderTesteDTO dto) {
		Aluno aluno = alunoRepository.findById(dto.alunoId())
				.orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

		Teste teste = testeRepository.findById(dto.testeId())
				.orElseThrow(() -> new EntityNotFoundException("Teste não encontrado"));

		// Obter todas as perguntas relacionadas ao teste
		List<Pergunta> perguntas = perguntaRepository.findByTesteId(teste.getId());

		for (Pergunta pergunta : perguntas) {
			// Verifica se existe uma resposta para a pergunta atual
			String respostaTexto = dto.respostas().get(pergunta.getId());
			if (respostaTexto != null) {
				Resposta resposta = new Resposta();
				resposta.setAluno(aluno); // Atribui o aluno à resposta
				resposta.setTeste(teste); // Atribui o teste à resposta
				resposta.setDataResposta(LocalDateTime.now());
				resposta.setDataCriacao(LocalDateTime.now());
				resposta.setDataAtualizacao(LocalDateTime.now());

				// Define a resposta do aluno
				resposta.setResposta(respostaTexto);

				respostaRepository.save(resposta); // Persistir a resposta no banco de dados
			}
		}
	}
}
