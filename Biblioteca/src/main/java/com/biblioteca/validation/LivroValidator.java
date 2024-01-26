package com.biblioteca.validation;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import org.apache.coyote.BadRequestException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class LivroValidator {

    @Autowired
    private static LivroRepository livroRepository;

    public static void validarCamposEmBranco(Livro livro) {
        if (livro.titulo.isBlank() || livro.genero.isBlank() || livro.autor.isBlank() ||
                livro.editora.isBlank() || livro.classificacao.isBlank()) {
            throw new BadRequestException("Nenhum campo pode estar em branco");
        }

    }

    public static void existePorTitulo(Livro livro) {
        if (livroRepository.existsByTitulo(livro.titulo)) {
            throw new BadRequestException("Livro já cadastrado");
        }
    }

    public static Livro existePorId(UUID idLivro) {
        LivroRepository livroRepository = null;
        Optional<Livro> livroPorId = livroRepository.findByid(idLivro);
        if (!livroPorId.isPresent()) {
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        } else {
            return livroPorId.get();
        }

    }
}
