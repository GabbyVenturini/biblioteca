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
    public ResponseEntity inserirlivro(@RequestBody Livro Livro) {
        livroService.inserirlivro(Livro);
        return ResponseEntity
                .status(HttpStatus.CREATED).body("Livro registrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarLivro(@PathVariable UUID idLivro) {
        livroService.buscarLivro(idLivro);
        return
                ResponseEntity.status(HttpStatus.OK).body("Livro encontrado!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarLivro(@PathVariable UUID idLivro) {
        livroService.atualizarLivro(idLivro);
        return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable UUID id) {
        livroService.deletarLivro(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT).body("Livro deletado com sucesso");
    }
}
