package com.example.projetomarket.repositorios;

import com.example.projetomarket.entidades.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}