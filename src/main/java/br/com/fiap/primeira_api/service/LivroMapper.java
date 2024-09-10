package br.com.fiap.primeira_api.service;

import br.com.fiap.primeira_api.dto.LivroRequest;
import br.com.fiap.primeira_api.dto.LivroRequestDTO;
import br.com.fiap.primeira_api.dto.LivroResponse;
import br.com.fiap.primeira_api.dto.LivroResponseDTO;
import br.com.fiap.primeira_api.model.Livro;
import org.springframework.hateoas.Link;
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

    // livroRequestDTO (Record) para Livro
    public Livro requestRecordToLivro(LivroRequestDTO livroRequestDTO) {
        Livro livro = new Livro();
        livro.setTitulo(livroRequestDTO.titulo());
        livro.setAutor(livroRequestDTO.autor());
        livro.setCategoria(livroRequestDTO.categoria());
        livro.setEditora(livroRequestDTO.editora());
        livro.setIsbn(livroRequestDTO.isbn());
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

    // livro para livroResponseDTO (Record)
    public LivroResponseDTO livroToResponseDTO(Livro livro, Link link) {
        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getCategoria().toString(),
                livro.getEditora(),
                livro.getIsbn(),
                link
        );
    }
}
