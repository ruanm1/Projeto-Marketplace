package com.example.projetomarket.repositorios;

import com.example.projetomarket.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}