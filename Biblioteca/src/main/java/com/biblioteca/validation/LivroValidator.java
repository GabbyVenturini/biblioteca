package com.biblioteca.validation;

import com.biblioteca.Exceptions.BadRequestException;
import com.biblioteca.model.Livro;
public class LivroValidator {

//    @Autowired
//    private static LivroRepository livroRepository;

    public static void validarCamposEmBranco(Livro livro) {
        if (livro.titulo.isBlank() || livro.genero.isBlank() || livro.autor.isBlank() || livro.editora.isBlank() || livro.classificacao.isBlank()) {
            throw new BadRequestException("Nenhum campo pode estar em branco");
        }
    }

//    public static void existePorTitulo(Livro livro) {
//        LivroRepository livroRepository = null;
//        if (livroRepository.existsByTitulo(livro.titulo)) {
//            throw new BadRequestException("Livro já cadastrado");
//        }
//    }

//    public static Livro existePorId(UUID idLivro) {
//        Optional<Livro> livroPorId = livroRepository.findByid(idLivro);
//        if (!livroPorId.isPresent()) {
//            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
//        } else {
//            return livroPorId.get();
//        }
//    }
}
