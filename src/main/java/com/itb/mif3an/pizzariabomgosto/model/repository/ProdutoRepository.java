package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT * FROM Produto p WHERE p.codStatus='1'", nativeQuery = true)
public List<Produto> findByAll();

    @Query(value = "SELECT * FROM Produto p WHERE p.id=?1 AND p.cod_status='1'",nativeQuery = true)
    public List<Produto> findAllByIdActive(Long id);
}
