package br.com.fiap.primeira_api.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "TB_PRATELEIRA")
public class Prateleira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @ManyToMany
    @JoinTable(name = "TB_LIVRO_PRATELEIRA",
            joinColumns = @JoinColumn(name = "ID_PRATELEIRA", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIVRO", referencedColumnName = "ID")
    )
    private Collection<Livro> livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Collection<Livro> livros) {
        this.livros = livros;
    }
}
