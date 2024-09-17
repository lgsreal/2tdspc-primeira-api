package br.com.fiap.primeira_api.dto;

import jakarta.validation.constraints.NotNull;

public record LivroPrateleiraRequest(
        @NotNull(message = "O id da prateleira é obrigatório")
        Long idPrateleira,
        @NotNull(message = "O id do livro é obrigatório")
        Long idLivro
) {
}
