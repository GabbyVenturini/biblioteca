package com.biblioteca.service;

import static com.biblioteca.validation.LivroValidator.validarCamposEmBranco;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public Livro inserirlivro(Livro livro) {
        validarCamposEmBranco(livro);
        buscarPorTitulo(livro);
        return livroRepository.save(livro);
    }

    @Transactional
    public void deletarLivro(UUID id) {
        var livro = buscarPorId(id);
        livroRepository.delete(livro);
    }

    @Transactional
    public Livro buscarLivro(UUID id) {
        var livroResponse = livroRepository.findById(id);

        if (livroResponse.isPresent()) {
            return livroResponse.get();
        } else {
            throw new ObjectNotFoundException(id, Livro.class.getSimpleName());
        }
    }

    @Transactional
    public Livro atualizarLivro(UUID id, Livro livro) {
        var livroResponse = livroRepository.findById(id);

        if (livroResponse.isPresent()) {
            var livroExistente = livroResponse.get();

            livroExistente.setTitulo(livro.getTitulo());
            livroExistente.setAutor(livro.getAutor());

            livroRepository.save(livroExistente);

            return livroExistente;
        } else {
            throw new ObjectNotFoundException(id, Livro.class.getSimpleName());
        }
    }

    public Livro buscarPorId(UUID id) {
        var livroPorId = livroRepository.findById(id);

        if (livroPorId.isPresent()) {
            return livroPorId.get();
        } else {
            throw new ObjectNotFoundException(id, Livro.class.getSimpleName());
        }
    }

    public void buscarPorTitulo(Livro livro) {
        if (livroRepository.existsByTitulo(livro.titulo)) {
            throw new RuntimeException("Livro já cadastrado");
        }
    }
}
