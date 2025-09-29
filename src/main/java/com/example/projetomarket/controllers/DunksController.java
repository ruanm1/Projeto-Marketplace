package com.example.projetomarket.controllers;

import com.example.projetomarket.entidades.Dunks;
import com.example.projetomarket.repositorios.DunksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dunks")
public class DunksController {

    @Autowired
    private DunksRepository dunksRepository;

    // GET (Passa todos os tenis)
    @GetMapping
    public List<Dunks> listaDeTenis(){
        return dunksRepository.findAll();
    }

    // GET/Id (Passa o tenis pelo id)
    @GetMapping("/{id}")
    public ResponseEntity<Dunks> listarPeloId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(dunksRepository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST (Adiciona um novo tenis)
    @PostMapping
    public Dunks adicionarTenis(@RequestBody Dunks novo){
        return dunksRepository.save(novo);
    }

    // PUT (Altera um tenis pelo id)
    @PutMapping("/{id}")
    public ResponseEntity<Dunks> atualizarTenis(@PathVariable Long id, @RequestBody Dunks novoTenis){
        try {
            Dunks tenisExistente = dunksRepository.findById(id).orElseThrow(NoSuchElementException::new);
            tenisExistente.setValor(novoTenis.getValor());
            tenisExistente.setModelo(novoTenis.getModelo());
            tenisExistente.setValor(novoTenis.getValor());

            Dunks tenisAtualizado = dunksRepository.save(tenisExistente);
            return new ResponseEntity<>(tenisAtualizado, HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE (Deleta um tenis pelo id)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPeloId(@PathVariable Long id){
        try {
            dunksRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
