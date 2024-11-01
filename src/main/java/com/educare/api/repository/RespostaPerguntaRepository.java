package com.educare.api.repository;

import com.educare.api.entity.Resposta;
import com.educare.api.entity.RespostaPergunta;
import com.educare.api.service.RespostaPerguntaService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaPerguntaRepository extends JpaRepository<RespostaPergunta, Integer> {
    List<RespostaPergunta> findByRespostaIn(List<Resposta> respostas);
}
