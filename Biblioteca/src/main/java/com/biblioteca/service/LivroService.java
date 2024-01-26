package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public ResponseEntity<Livro> buscarLivro(UUID idLivro) {
        var livro = livroRepository.findById(idLivro);
        if (livro.isPresent()) {
            return livro.get();
        } else {
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        }
    }

    public ResponseEntity<Livro> atualizarLivro(UUID idLivro, Livro novoLivro) {
        var atualizarLivro = livroRepository.findById(idLivro);
        if (atualizarLivro.isPresent()) {
            var livro = atualizarLivro.get();
            livro.setTitulo(novoLivro.getTitulo());
            return livroRepository.save(livro);
        } else {
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        }
    }
}
