package br.com.fiap.primeira_api.dto;

import br.com.fiap.primeira_api.model.Categoria;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

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
    @Min(value = 1000000000L, message = "O ISBN do livro deve ter no mínimo 10 caracteres")
    // 1234567891012L
    @Max(value = 9999999999999L, message = "O ISBN do livro deve ter no máximo 13 caracteres")
    private Long isbn;

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

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
