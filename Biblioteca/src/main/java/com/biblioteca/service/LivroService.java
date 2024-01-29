package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.validation.LivroValidator;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroValidator livroValidator;

    @Transactional
    public Livro inserirlivro(Livro livro) {
        livroValidator.validarCamposEmBranco(livro);
        livroValidator.existePorTitulo(livro);
      return livroRepository.save(livro);
    }

    @Transactional
    public void deletarLivro(UUID id) {
        var livro = livroValidator.existePorId(id);
        livroRepository.delete(livro);
    }

    @Transactional
    public Livro buscarLivro(UUID id) {
        var livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            ResponseEntity.ok(livro.get());
        } else {
            throw new ObjectNotFoundException(id, Livro.class.getSimpleName());
        }
        return livroRepository.getReferenceById(id);
    }

    @Transactional
    public boolean atualizarLivro(Livro novoLivro) {
        var atualizarLivro = livroRepository.existsByTitulo(novoLivro.titulo);
        if (atualizarLivro) {
            atualizarLivro(novoLivro);
            ResponseEntity.ok(novoLivro.titulo);
        } else {
            throw new ObjectNotFoundException(novoLivro.getId(), Livro.class.getSimpleName());
        }
        return livroRepository.existsByTitulo(novoLivro.titulo);
    }
}
