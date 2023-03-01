package com.example.android_livraria;

import android.net.Uri;

public class Livro {
    private Integer foto;
    private String titulo, autor, editora;
    private Integer ano;
    private Uri foto2;

    public Livro(Integer foto, String titulo, String autor, String editora, Integer ano){
        this.foto = foto;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
    }

    public Livro(Uri foto2, String titulo, String autor, String editora, Integer ano){
        this.foto2 = foto2;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
    }

    public Integer getFoto() {
        return foto;
    }

    public Uri getFoto2() {
        return foto2;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "{ foto: " + foto +
                ", foto2=" + foto2 +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", ano=" + ano +
                '}';
    }
}