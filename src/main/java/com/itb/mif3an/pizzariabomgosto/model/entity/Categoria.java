package com.itb.mif3an.pizzariabomgosto.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
		if(nome == null || nome.isEmpty()) {
			mensagemErro += "O nome da categoria é obrigatório:";
			isValid = false;
		}
		return isValid;
		
	}

	
	
}


