package com.itb.mif3an.pizzariabomgosto.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 250)
    private String descricao;
    @Column(nullable = false, length = 45)
    private boolean cod_status;

    //Relacionamento 1:N

    //@OneToMany : Um para Muitos ex: Uma categoria para muitos produtos
    //CascadeType.ALL : Define como as operações de persistência (INSERT, UPDATE, DELETE)
    //					serão propagadas de uma entidade pai para uma entidade filha no banco
    //					de dados, todas as operações feitas na entidadde pai serão replicadas
    //					automaticamente para a entidade filha
    //Além do "ALL", temos: PERSIST, MERGE, REMOVE, REFRESH, DETACH

    //fetch: Define como os dados relacionados serão carregados do banco de dados quando a
    //		 entidade for consultada.
    //FetchType.LAZY: Os dados relacionados só serão carregados quando forem acessados explicitamente
    //				  no código
    //Além do "LAZY", temos: EAGER -> Os dados da classe filha é carregada no momento que eu carrego a classe pai

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();


    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCod_status() {
        return cod_status;
    }

    public void setCod_status(boolean cod_status) {
        this.cod_status = cod_status;

    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        return Objects.equals(id, other.id);
    }

    public boolean validarCategoria() {
        if (nome == null || nome.isEmpty()) {
            mensagemErro += "O nome da categoria é obrigatório:";
            isValid = false;
        }
        return isValid;

    }


}


