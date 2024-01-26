package com.biblioteca.validation;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

public class Validator {

    @Autowired
    private static LivroRepository livroRepository;

    public static void validarCampo(Livro livro) {
        if (livro.titulo.isBlank() || livro.genero.isBlank() || livro.autor.isBlank() ||
                livro.editora.isBlank() || livro.classificacao.isBlank()) {
            throw new BadRequestException("Nenhum campo pode estar em branco");
        }

    }

    public static void validarLivroExistente(Livro livro) {
        if (livroRepository.existsByTitulo(livro.titulo)) {
            throw new BadRequestException("Livro já cadastrado");
        }
    }
}
