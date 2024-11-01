package com.educare.api.service;

import com.educare.api.dto.PerguntaComRespostaDTO;
import com.educare.api.dto.ResponderTesteDTO;
import com.educare.api.dto.TesteComPerguntasERespostasDTO;
import com.educare.api.dto.TesteDTO;
import com.educare.api.entity.*;
import com.educare.api.repository.TesteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TesteService {

	@Autowired
	TesteRepository testeRepository;

	@Autowired
	AlunoService alunoService;

	@Autowired
	PerguntaService perguntaService;

	@Autowired
	RespostaService respostaService;

	@Autowired
	RespostaPerguntaService respostaPerguntaService;


	public Teste cadastrar(TesteDTO dto) {
		return testeRepository.save(new Teste(dto));
	}

	public List<Teste> listar() {
		return testeRepository.findAll();
	}

	public Teste pesquisarPorId(Long id) {
		return testeRepository.findById(id.intValue()).orElseThrow(() -> new EntityNotFoundException());
	}

	public boolean deletar(Long id) {
		testeRepository.delete(pesquisarPorId(id));
		return true;
	}

	public void responderTeste(Integer testeId, ResponderTesteDTO responderTesteDTO) {

		Aluno aluno = alunoService.pesquisarPorId(responderTesteDTO.alunoId().longValue());
		Teste teste = testeRepository.findById(testeId).orElseThrow(() -> new RuntimeException("Teste não encontrado"));


		Resposta resposta = new Resposta();
		resposta.setAluno(aluno);
		resposta.setTeste(teste);
		resposta.setDataResposta(LocalDateTime.now());

		respostaService.cadastrarAtualizar(resposta);


		for (ResponderTesteDTO.PerguntaRespostaDTO perguntaRespostaDTO : responderTesteDTO.respostas()) {
			Pergunta pergunta = perguntaService.pesquisarPorId(perguntaRespostaDTO.perguntaId().longValue());

			RespostaPergunta respostaPergunta = new RespostaPergunta();
			respostaPergunta.setResposta(resposta);
			respostaPergunta.setPergunta(pergunta);
			respostaPerguntaService.cadastrar(respostaPergunta);
		}
	}

	public TesteComPerguntasERespostasDTO getTesteComPerguntasERespostas(Integer alunoId, Integer testeId) {
		Teste teste = pesquisarPorId(testeId.longValue());

		List<Resposta> respostas = respostaService.pesquisarRepostasTesteAluno(alunoId, testeId);

		if (respostas.isEmpty()) {
			throw new EntityNotFoundException("O aluno não respondeu a este teste.");
		}

		List<RespostaPergunta> respostasPerguntas = respostaPerguntaService.pesquisarListaRespostasPergunta(respostas);

		List<PerguntaComRespostaDTO> perguntasComRespostas = teste.getPerguntas().stream()
				.map(pergunta -> {
					String respostaTexto = respostasPerguntas.stream()
							.filter(respostaPergunta -> respostaPergunta.getPergunta().getId().equals(pergunta.getId()))
							.map(respostaPergunta -> respostaPergunta.getResposta().getResposta())
							.findFirst()
							.orElse(null);
					return new PerguntaComRespostaDTO(pergunta.getId(), pergunta.getPergunta(), respostaTexto);
				})
				.collect(Collectors.toList());

		return new TesteComPerguntasERespostasDTO(teste.getId(), teste.getNome(), teste.getDescricao(), perguntasComRespostas);
	}
}
