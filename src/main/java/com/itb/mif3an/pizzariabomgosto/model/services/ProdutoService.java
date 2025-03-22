package com.itb.mif3an.pizzariabomgosto.model.services;

import com.itb.mif3an.pizzariabomgosto.model.entity.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto findById(Long id);
    public Produto save(Produto produto);
    public boolean delete(Long id);
    public Produto update(Produto produto, Long id);
    public List<Produto> findAll();
}
