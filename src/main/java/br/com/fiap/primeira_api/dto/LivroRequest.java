package br.com.fiap.primeira_api.dto;

import br.com.fiap.primeira_api.model.Categoria;
import jakarta.validation.constraints.*;

public class LivroRequest {
    @NotBlank(message = "O título do livro é obrigatório")
    private String titulo;
    @NotBlank(message = "A autoria do livro é obrigatória")
    private String autor;
    @NotNull(message = "A categoria do livro é uma informação necessária")
    private Categoria categoria;
    @Size(min = 3, max = 10, message = "O nome da editora deve ter no mínimo 3 e no máximo 10 caracteres")
    @NotBlank(message = "O nome da editora é obrigatório")
    private String editora;
    @Pattern(regexp = "^\\d{10}$|^\\d{13}$", message = "O ISBN deve ter 10 ou 13 dígitos")
    private String isbn;

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
