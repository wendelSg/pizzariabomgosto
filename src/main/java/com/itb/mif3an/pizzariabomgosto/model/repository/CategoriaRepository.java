package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM Categoria p WHERE p.codStatus='1'", nativeQuery = true)
    public List<Categoria> findByAll();

    @Query(value = "SELECT * FROM Categoria p WHERE p.id=?1 AND p.cod_status='1'",nativeQuery = true)
    public List<Categoria> findByIdActivate(Long id);

}
