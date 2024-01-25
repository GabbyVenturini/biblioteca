package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository livroRepository;
    public Livro buscarLivro(UUID idLivro) {
        var livro = livroRepository.findById(idLivro);
        if(livro.isPresent()){
            return livro.get();
        }else{
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        }
    }

    public Livro atualizarLivro(UUID idLivro, Livro novoLivro) {
        var atualizarLivro = livroRepository.findById(idLivro);
        if(atualizarLivro.isPresent()){
            var livro = atualizarLivro.get();
            livro.setTitulo(novoLivro.getTitulo());
            return livroRepository.save(livro);
        }else{
            throw new ObjectNotFoundException(idLivro, Livro.class.getSimpleName());
        }
    }
}
