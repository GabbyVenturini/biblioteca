package com.biblioteca.validation;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LivroValidator {

    @Autowired
    private LivroRepository livroRepository;

    public void validarCamposEmBranco(Livro livro) {
        if (livro.titulo.isBlank() || livro.genero.isBlank() || livro.autor.isBlank() || livro.editora.isBlank() || livro.classificacao.isBlank()) {
            throw new RuntimeException("Nenhum campo pode estar em branco");
        }
    }

    public void existePorTitulo(Livro livro) {
        if (livroRepository.existsByTitulo(livro.titulo)) {
            throw new RuntimeException("Livro já cadastrado");
        }
    }

    public Livro existePorId(UUID idLivro) {
        LivroRepository livroRepository = null;
        Optional<Livro> livroPorId = livroRepository.findById(idLivro);
        if (!livroPorId.isPresent()) {
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        } else {
            return livroPorId.get();
        }
    }
}
