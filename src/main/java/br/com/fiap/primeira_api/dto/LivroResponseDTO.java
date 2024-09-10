package br.com.fiap.primeira_api.dto;

import org.springframework.hateoas.Link;

public record LivroResponseDTO(
        Long id,
        String titulo,
        String autor,
        String categoria,
        String editora,
        String isbn,
        Link link
) {
}
