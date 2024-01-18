package com.biblioteca.model;

public class Livros {

    public String titulo;
    public String genero;
    public String autor;
    public String editora;
    public String classificacao;

     public Livros(String titulo, String genero, String autor, String editora, String classificacao) {
          this.titulo = titulo;
          this.genero = genero;
          this.autor = autor;
          this.editora = editora;
          this.classificacao = classificacao;
     }

     public Livros() {
     }

     public String getTitulo() {
          return titulo;
     }

     public void setTitulo(String titulo) {
          this.titulo = titulo;
     }

     public String getGenero() {
          return genero;
     }

     public void setGenero(String genero) {
          this.genero = genero;
     }

     public String getAutor() {
          return autor;
     }

     public void setAutor(String autor) {
          this.autor = autor;
     }

     public String getEditora() {
          return editora;
     }

     public void setEditora(String editora) {
          this.editora = editora;
     }

     public String getClassificacao() {
          return classificacao;
     }

     public void setClassificacao(String classificacao) {
          this.classificacao = classificacao;
     }
}
