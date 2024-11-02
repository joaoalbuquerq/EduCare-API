package com.educare.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educare.api.entity.Pergunta;

import java.util.List;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer>{

    List<Pergunta> findByTesteId(Integer testeId);
}
