package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {
    
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/{id}")
    public Livro buscarLivro(@PathVariable UUID idLivro){
        return livroService.buscarLivro(idLivro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable UUID idLivro, @RequestBody Livro novoLivro){
        return livroService.atualizarLivro(idLivro, novoLivro);
    }
}
