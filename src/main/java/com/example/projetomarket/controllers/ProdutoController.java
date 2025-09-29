package com.example.projetomarket.controllers;

import com.example.projetomarket.entidades.Produto;
import com.example.projetomarket.repositorios.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository repository;
    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = repository.findById(id).orElseThrow();
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        return repository.save(produto);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

