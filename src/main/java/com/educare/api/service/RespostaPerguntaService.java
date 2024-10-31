package com.educare.api.service;

import com.educare.api.entity.RespostaPergunta;
import com.educare.api.repository.RespostaPerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaPerguntaService {

    @Autowired
    RespostaPerguntaRepository repository;

    public RespostaPergunta cadastrar(RespostaPergunta respostaPergunta) {
        return repository.save(respostaPergunta);
    }
}
