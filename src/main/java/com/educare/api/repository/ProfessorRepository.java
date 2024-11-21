package com.educare.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.educare.api.entity.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    
}
