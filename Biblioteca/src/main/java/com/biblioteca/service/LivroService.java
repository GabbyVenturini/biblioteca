package com.biblioteca.service;

import com.biblioteca.Exceptions.BadRequestException;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.biblioteca.validation.LivroValidator.validarCamposEmBranco;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void inserirlivro(Livro livro) {
        validarCamposEmBranco(livro);
//        existePorTitulo(livro);
        if (livroRepository.existsByTitulo(livro.titulo)) {
            throw new BadRequestException("Livro já cadastrado");
        }
        livroRepository.save(livro);
    }

    @Transactional
    public void deletarLivro(UUID id) {
//        var livro = existePorId(id);
        Optional<Livro> livroPorId = livroRepository.findByid(id);
        if (!livroPorId.isPresent()) {
            throw new ObjectNotFoundException(id, Livro.class.getSimpleName());
        }
        livroRepository.delete(livroPorId.get());
    }

    @Transactional
    public void buscarLivro(UUID idLivro) {
        var livro = livroRepository.findById(idLivro);
        if (livro.isPresent()) {
            ResponseEntity.ok(livro.get());
        } else {
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        }
    }

    @Transactional
    public void atualizarLivro(UUID idLivro) {
        var atualizarLivro = livroRepository.findById(idLivro);
        if (atualizarLivro.isPresent()) {
            atualizarLivro.get();
            ResponseEntity.ok(idLivro);
        } else {
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        }
    }
}
