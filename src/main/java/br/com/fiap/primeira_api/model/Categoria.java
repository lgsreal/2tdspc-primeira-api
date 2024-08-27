package br.com.fiap.primeira_api.model;

public enum Categoria {
    ROMANCE("Romance"),
    FICCAO("Ficção"),
    FANTASIA("Fantasia"),
    BIOGRAFIA("Biografia"),
    PSICOLOGIA("Psicologia"),
    TERROR("Terror"),
    PROGRAMACAO("Programação"),
    AUTOAJUDA("Auto-Ajuda");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
