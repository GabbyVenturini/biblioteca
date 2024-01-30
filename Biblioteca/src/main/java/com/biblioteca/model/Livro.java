package com.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Livro")
@Getter
@Setter
public class Livro implements Serializable {

    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
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
