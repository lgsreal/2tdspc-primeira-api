package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.dto.LivroPrateleiraRequest;
import br.com.fiap.primeira_api.dto.PrateleiraRequest;
import br.com.fiap.primeira_api.model.Livro;
import br.com.fiap.primeira_api.model.Prateleira;
import br.com.fiap.primeira_api.repository.LivroRepository;
import br.com.fiap.primeira_api.repository.PrateleiraRepository;
import br.com.fiap.primeira_api.service.LivroMapper;
import br.com.fiap.primeira_api.service.PrateleiraMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prateleiras")
public class PrateleiraController {
    @Autowired
    private PrateleiraRepository prateleiraRepository;
    @Autowired
    private PrateleiraMapper prateleiraMapper;
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Prateleira> createPrateleira(@Valid @RequestBody PrateleiraRequest prateleiraRequest) {
        Prateleira prateleira = prateleiraMapper.requestToPrateleira(prateleiraRequest);
        prateleira = prateleiraRepository.save(prateleira);
        if (prateleira.getId() != null) {
            return new ResponseEntity<>(prateleira, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Void> addLivroPrateleira(@Valid @RequestBody LivroPrateleiraRequest livroPrateleiraRequest) {
        Optional<Prateleira> prateleira = prateleiraRepository.findById(livroPrateleiraRequest.idPrateleira());
        Optional<Livro> livro = livroRepository.findById(livroPrateleiraRequest.idLivro());
        if (prateleira.isEmpty() || livro.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        prateleira.get().getLivros().add(livro.get());
        prateleiraRepository.save(prateleira.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Prateleira>> readPrateleiras() {
        List<Prateleira> prateleiras = prateleiraRepository.findAll();
        if (prateleiras.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prateleiras, HttpStatus.OK);
    }
}
