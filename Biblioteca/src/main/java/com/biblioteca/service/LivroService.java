package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public Livro inserirLivro(Livro inserirLivro) {
        List<String> validarlivro = new ArrayList<>();
        if (inserirLivro.titulo.isBlank() || inserirLivro.genero.isBlank() || inserirLivro.autor.isBlank() ||
                inserirLivro.editora.isBlank() || inserirLivro.classificacao.isBlank()) {
            throw new BadRequestException("Nenhum campo pode estar em branco");
        }
        if (livroRepository.existsByTitulo(inserirLivro.titulo)) {
            throw new BadRequestException("Livro já cadastrado");
        }
        return livroRepository.save(inserirLivro);
    }
}
