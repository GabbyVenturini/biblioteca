package com.biblioteca.validation;

import com.biblioteca.model.Livro;

public class LivroValidator {

    public static void validarCamposEmBranco(Livro livro) {
        if (livro.titulo.isBlank() || livro.genero.isBlank() || livro.autor.isBlank() || livro.editora.isBlank() || livro.classificacao.isBlank()) {
            throw new RuntimeException("Nenhum campo pode estar em branco");
        }
    }
}
