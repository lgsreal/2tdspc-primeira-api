package br.com.fiap.primeira_api.service;

import br.com.fiap.primeira_api.dto.LivroRequest;
import br.com.fiap.primeira_api.dto.LivroResponse;
import br.com.fiap.primeira_api.model.Livro;
import org.springframework.stereotype.Service;

@Service
public class LivroMapper {
    // livroRequest para livro
    public Livro requestToLivro(LivroRequest livroRequest) {
        Livro livro = new Livro();
        livro.setTitulo(livroRequest.getTitulo());
        livro.setAutor(livroRequest.getAutor());
        livro.setCategoria(livroRequest.getCategoria());
        livro.setEditora(livroRequest.getEditora());
        livro.setIsbn(livroRequest.getIsbn());
        return livro;
    }

    // livro para livroResponse
    public LivroResponse livroToResponse(Livro livro) {
        LivroResponse livroResponse = new LivroResponse();
        livroResponse.setId(livro.getId());
        livroResponse.setTitulo(livro.getTitulo());
        livroResponse.setAutor(livro.getAutor());
        livroResponse.setCategoria(livro.getCategoria().toString());
        livroResponse.setEditora(livro.getEditora());
        livroResponse.setIsbn(livro.getIsbn());
        return livroResponse;
    }
}
