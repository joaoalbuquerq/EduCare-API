package com.educare.api.repository;

import com.educare.api.entity.RespostaPergunta;
import com.educare.api.service.RespostaPerguntaService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaPerguntaRepository extends JpaRepository<RespostaPergunta, Integer> {
}
