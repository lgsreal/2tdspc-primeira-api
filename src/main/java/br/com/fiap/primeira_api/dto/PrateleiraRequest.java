package br.com.fiap.primeira_api.dto;

import jakarta.validation.constraints.NotBlank;

public record PrateleiraRequest(
        @NotBlank(message = "O nome da prateleira é obrigatório")
        String nome,
        String descricao
) {
}
