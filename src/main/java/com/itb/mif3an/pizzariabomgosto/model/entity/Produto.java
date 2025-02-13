package com.itb.mif3an.pizzariabomgosto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (nullable = false,length = 100)
	private String nome;
	@Column(nullable = false,length = 250)
	private String descricao;
	@Column(nullable = false,length = 45)
	private String tipo;
	@Column(nullable = true)
	private int quantidadeEstoque;
	@Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
	private double precoVenda;
	
	private double precoCompra;
	private boolean codStatus;
	
	// atributos de apoio
	
	private String mensagemErro = "";
	private boolean isValid = true;
	

}
