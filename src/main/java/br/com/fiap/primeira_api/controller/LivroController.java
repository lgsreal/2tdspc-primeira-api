package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.model.Livro;
import br.com.fiap.primeira_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// localhost:8080/livros
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    // CRUD - Create, Read, Update, Delete
    // HTTP verbs - POST, GET, PUT, DELETE
    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro livroCriado = livroRepository.save(livro);
        return new ResponseEntity<>(livroCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> readLivros() {
        List<Livro> listaLivros = livroRepository.findAll();
        return new ResponseEntity<>(listaLivros, HttpStatus.OK);
    }
}
