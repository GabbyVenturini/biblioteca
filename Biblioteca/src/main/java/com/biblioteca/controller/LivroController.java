package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping("/inserir")
    public ResponseEntity<Livro> inserirLivro(@RequestBody Livro inserirLivro) {
        return livroService.livro(inserirLivro);

    }
}
