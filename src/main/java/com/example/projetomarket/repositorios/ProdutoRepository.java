package com.example.projetomarket.repositorios;

import com.example.projetomarket.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
