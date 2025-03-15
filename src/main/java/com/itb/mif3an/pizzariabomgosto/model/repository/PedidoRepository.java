package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Pedido;
import com.itb.mif3an.pizzariabomgosto.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM Pedido p WHERE p.codStatus='1'", nativeQuery = true)
    public List<Produto> findByAll();

    @Query(value = "SELECT * FROM Pedido p WHERE p.id=?1 AND p.cod_status='1'",nativeQuery = true)
    public List<Produto> findAllByIdActive(Long id);

}
