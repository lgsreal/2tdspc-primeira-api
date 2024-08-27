package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.model.Livro;
import br.com.fiap.primeira_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Livro> readLivro(@PathVariable Long id) {
        Optional<Livro> livroSalvo = livroRepository.findById(id);
        if (livroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(livroSalvo.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        Optional<Livro> livroSalvo = livroRepository.findById(id);
        if (livroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        livro.setId(id);
        Livro livroAtualizado = livroRepository.save(livro);
        return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
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









