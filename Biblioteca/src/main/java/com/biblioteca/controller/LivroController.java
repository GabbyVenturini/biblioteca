package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable UUID idLivro) {
        return livroService.buscarLivro(idLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable UUID idLivro, @RequestBody Livro novoLivro) {
        return livroService.atualizarLivro(idLivro, novoLivro);
    }
}
