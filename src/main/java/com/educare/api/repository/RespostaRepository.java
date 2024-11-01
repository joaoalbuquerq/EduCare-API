package com.educare.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educare.api.entity.Resposta;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Integer>{

    List<Resposta> findByAlunoIdAndTesteId(Integer alunoId, Integer testeId);
}
