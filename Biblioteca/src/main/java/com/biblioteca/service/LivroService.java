package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.validation.Validator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public ResponseEntity livro(Livro livro) {
        Validator.validarCampo(livro);
        Validator.validarLivroExistente(livro);
        livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro registrado com sucesso!")
    }
}
