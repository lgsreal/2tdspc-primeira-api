package br.com.fiap.primeira_api.dto;

import br.com.fiap.primeira_api.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {}
