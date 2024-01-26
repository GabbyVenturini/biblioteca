package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.validation.LivroValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.biblioteca.validation.LivroValidator.existePorTitulo;
import static com.biblioteca.validation.LivroValidator.validarCamposEmBranco;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroValidator livroValidator;

    @Transactional
    public void inserirlivro(Livro livro) {
        validarCamposEmBranco(livro);
        existePorTitulo(livro);
        livroRepository.save(livro);

    }

    @Transactional
    public void deletarLivro(UUID idLivro) {
        var livro = LivroValidator.existePorId(idLivro);
        livroRepository.delete(livro);
    }
}
