package br.com.fiap.primeira_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LIVROS")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "livro_titulo")
    private String titulo;
    @Column(name = "livro_autor")
    private String autor;
    @Enumerated(EnumType.STRING)
    @Column(name = "livro_categoria")
    private Categoria categoria;
    @Column(name = "livro_editora")
    private String editora;
    @Column(name = "livro_isbn")
    private String isbn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
