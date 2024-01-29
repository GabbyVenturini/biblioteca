package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping("/inserir")
    public ResponseEntity inserirlivro(@RequestBody Livro livro) {
       var livroResponse = livroService.inserirlivro(livro);
        return ResponseEntity
                .status(HttpStatus.CREATED).body(livroResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarLivro(@PathVariable UUID id) {
        var livroResponse = livroService.buscarLivro(id);
        return
                ResponseEntity.status(HttpStatus.OK).body(livroResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarLivro(@PathVariable UUID id, @RequestBody Livro novoLivro) {
        livroService.atualizarLivro(novoLivro);
        return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarLivro(@PathVariable UUID id) {
        livroService.deletarLivro(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT).body("Livro deletado com sucesso");
    }
}
