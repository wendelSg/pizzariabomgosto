package com.itb.mif3an.pizzariabomgosto.model.services;

import com.itb.mif3an.pizzariabomgosto.exceptions.BadRequest;
import com.itb.mif3an.pizzariabomgosto.exceptions.NotFound;
import com.itb.mif3an.pizzariabomgosto.model.entity.Produto;
import com.itb.mif3an.pizzariabomgosto.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{


    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public Produto findById(Long id) {
        try {
            Produto produto = produtoRepository.findById(id).get();
            return produto;
        } catch (Exception e) {
            throw new NotFound("Produto não encontrado com o id " + id);
        }

    }


    @Override
    @Transactional
    public Produto save(Produto produto) {
        if (!produto.validarProduto()) {
            throw new BadRequest(produto.getMensagemErro());

        }
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional              //@Trasactional == efetiva o DML insert,delete,update... ou desfaz caso não seja possivel
    public boolean delete(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }else {
            throw new NotFound("Produto não encontrado com o id " + id);
        }

    }

    @Override
    public Produto update(Produto produto, Long id) {
        if(!produto.validarProduto()) {

            throw new BadRequest(produto.getMensagemErro());
        }
        if (!produtoRepository.existsById(id)) {
            throw new NotFound("Produto não encontrado com o id " + id);
        }

        return null;
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }


    }






//repository acessa o banco
//services logica maior complexidade