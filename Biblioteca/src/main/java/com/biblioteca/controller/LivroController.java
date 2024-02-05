package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/inserir")
    public ResponseEntity<Livro> inserirlivro(@RequestBody Livro Livro) {
        var livro = livroService.inserirlivro(Livro);

        return ResponseEntity
            .status(HttpStatus.CREATED).body(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable UUID id) {
        var livro = livroService.buscarLivro(id);

        return ResponseEntity
            .status(HttpStatus.OK).body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable UUID id, @RequestBody Livro livro) {
        var livroResponse = livroService.atualizarLivro(id, livro);

        return ResponseEntity
            .status(HttpStatus.OK).body(livroResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable UUID id) {
        livroService.deletarLivro(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT).body("Livro deletado com sucesso");
    }
    //
}
