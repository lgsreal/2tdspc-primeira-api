package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.dto.LivroRequest;
import br.com.fiap.primeira_api.dto.LivroResponse;
import br.com.fiap.primeira_api.model.Livro;
import br.com.fiap.primeira_api.repository.LivroRepository;
import br.com.fiap.primeira_api.service.LivroMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
// localhost:8080/livros
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroMapper livroMapper;

    // CRUD - Create, Read, Update, Delete
    // HTTP verbs - POST, GET, PUT, DELETE
    @PostMapping
    public ResponseEntity<LivroResponse> createLivro(@Valid @RequestBody LivroRequest livroRequest) {
        Livro livroConvertido = livroMapper.requestToLivro(livroRequest);
        Livro livroCriado = livroRepository.save(livroConvertido);
        LivroResponse livroResponse = livroMapper.livroToResponse(livroCriado);
        return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> readLivros() {
        List<Livro> listaLivros = livroRepository.findAll();
        if (listaLivros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<LivroResponse> listaLivrosResponse = new ArrayList<>();
        for (Livro livro : listaLivros) {
            LivroResponse livroResponse = livroMapper.livroToResponse(livro);
            listaLivrosResponse.add(livroResponse);
        }
        return new ResponseEntity<>(listaLivrosResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> readLivro(@PathVariable Long id) {
        Optional<Livro> livroSalvo = livroRepository.findById(id);
        if (livroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LivroResponse livroResponse = livroMapper.livroToResponse(livroSalvo.get());
        return new ResponseEntity<>(livroResponse, HttpStatus.OK);
    }

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









