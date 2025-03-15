package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Produto;
import com.itb.mif3an.pizzariabomgosto.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM Usuario p WHERE p.codStatus='1'", nativeQuery = true)
    public List<Produto> findByAll();

    @Query(value = "SELECT * FROM Usuario p WHERE p.id=?1 AND p.cod_status='1'",nativeQuery = true)
    public List<Produto> findAllByIdActive(Long id);
}
