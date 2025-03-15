package com.itb.mif3an.pizzariabomgosto.model.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 50)
	private String numero;
	
	private boolean codStatus;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_Id", referencedColumnName = "id",nullable = true)
	private Usuario usuario;
	
	
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isCodStatus() {
		return codStatus;
	}
	public void setCodStatus(boolean codStatus) {
		this.codStatus = codStatus;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
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
		Telefone other = (Telefone) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	public boolean validarTelefone() {
		if(numero == null || numero.isEmpty()) {
			mensagemErro += "O número deve ser preenchido:";
		}
			
			
	
	
		return isValid;
	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	

	
		

