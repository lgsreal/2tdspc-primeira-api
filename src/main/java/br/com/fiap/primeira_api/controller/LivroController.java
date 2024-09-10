package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.dto.LivroRequest;
import br.com.fiap.primeira_api.dto.LivroResponse;
import br.com.fiap.primeira_api.model.Livro;
import br.com.fiap.primeira_api.repository.LivroRepository;
import br.com.fiap.primeira_api.service.LivroMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
// localhost:8080/livros
@RequestMapping(value = "/livros", produces = {"application/json"})
@Tag(name = "api-livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroMapper livroMapper;

    Pageable paginacao = PageRequest.of(0, 2, Sort.by("titulo").descending());

    // CRUD - Create, Read, Update, Delete
    // HTTP verbs - POST, GET, PUT, DELETE

    @Operation(summary = "Cria um livro e grava no banco")
    @ApiResponse(responseCode = "201", description = "Livro cadastrado com sucesso")
    @PostMapping
    public ResponseEntity<LivroResponse> createLivro(@Valid @RequestBody LivroRequest livroRequest) {
        Livro livroConvertido = livroMapper.requestToLivro(livroRequest);
        Livro livroCriado = livroRepository.save(livroConvertido);
        LivroResponse livroResponse = livroMapper.livroToResponse(livroCriado);
        return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna todos os livros persistidos")
    @GetMapping
    public ResponseEntity<List<LivroResponse>> readLivros() {
        Page<Livro> listaLivros = livroRepository.findAll(paginacao);
        if (listaLivros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<LivroResponse> listaLivrosResponse = new ArrayList<>();
        for (Livro livro : listaLivros) {
            LivroResponse livroResponse = livroMapper.livroToResponse(livro);
            livroResponse.setLink(
                    linkTo(
                            methodOn(LivroController.class)
                                    .readLivro(livroResponse.getId())
                    ).withSelfRel()
            );
            listaLivrosResponse.add(livroResponse);
        }
        return new ResponseEntity<>(listaLivrosResponse, HttpStatus.OK);
    }

    @Operation(summary = "Retorna um livro dado o seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> readLivro(@PathVariable Long id) {
        Optional<Livro> livroSalvo = livroRepository.findById(id);
        if (livroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LivroResponse livroResponse = livroMapper.livroToResponse(livroSalvo.get());
        livroResponse.setLink(
                linkTo(
                        methodOn(LivroController.class)
                                .readLivros()
                ).withRel("Lista de Livros")
        );
        return new ResponseEntity<>(livroResponse, HttpStatus.OK);
    }

    @Operation(summary = "Atualiza um livro já existente no banco")
    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> update(@PathVariable Long id, @Valid @RequestBody LivroRequest livroRequest) {
        Optional<Livro> livroSalvo = livroRepository.findById(id);
        if (livroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Livro livro = livroMapper.requestToLivro(livroRequest);
        livro.setId(id);
        Livro livroAtualizado = livroRepository.save(livro);
        LivroResponse livroResponse = livroMapper.livroToResponse(livroAtualizado);
        return new ResponseEntity<>(livroResponse, HttpStatus.OK);
    }

    @Operation(summary = "Exclui um livro do banco de dados dado um ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Livro> livroSalvo = livroRepository.findById(id);
        if (livroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        livroRepository.delete(livroSalvo.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}









