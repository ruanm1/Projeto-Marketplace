package com.example.projetomarket.controllers;

import com.example.projetomarket.entidades.Pagamento;
import com.example.projetomarket.repositorios.PagamentoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")

public class PagamentoController {
    private final PagamentoRepository repository;
    public PagamentoController(PagamentoRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Pagamento> listar() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Pagamento buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
    @PostMapping
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return repository.save(pagamento);
    }
    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable Long id, @RequestBody Pagamento pagamentoAtualizado) {
        Pagamento pagamento = repository.findById(id).orElseThrow();
        pagamento.setMetodo(pagamentoAtualizado.getMetodo());
        pagamento.setValor(pagamentoAtualizado.getValor());
        return repository.save(pagamento);
    } @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}