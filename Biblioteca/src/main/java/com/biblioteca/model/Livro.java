package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Livros")
@Data
@NoArgsConstructor
public class Livro implements Serializable {

    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idLivro;
    @Column(nullable = false)
    public String titulo;
    @Column(nullable = false)
    public String genero;
    @Column(nullable = false)
    public String autor;
    @Column(nullable = false)
    public String editora;
    @Column(nullable = false)
    public String classificacao;
    @Column(nullable = false)
    public int quantidade;


}
