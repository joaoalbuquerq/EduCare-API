package com.educare.api.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.educare.api.entity.Teste;

import java.util.Optional;

public interface TesteRepository extends JpaRepository<Teste, Integer>{
    @EntityGraph(attributePaths = "perguntas")
    Optional<Teste> findById(Integer id);
}
