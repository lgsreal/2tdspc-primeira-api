package br.com.fiap.primeira_api.dto;

import br.com.fiap.primeira_api.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LivroRequestDTO(
        @NotBlank(message = "O título do livro é obrigatório")
        String titulo,
        @NotBlank(message = "A autoria do livro é obrigatória")
        String autor,
        @NotNull(message = "A categoria do livro é uma informação necessária")
        Categoria categoria,
        @Size(min = 3, max = 10, message = "O nome da editora deve ter no mínimo 3 e no máximo 10 caracteres")
        @NotBlank(message = "O nome da editora é obrigatório")
        String editora,
        @Pattern(regexp = "^\\d{10}$|^\\d{13}$", message = "O ISBN deve ter 10 ou 13 dígitos")
        String isbn
) {
}
