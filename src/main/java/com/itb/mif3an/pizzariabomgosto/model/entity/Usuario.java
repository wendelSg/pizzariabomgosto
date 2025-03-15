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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true, length = 100)
	private String nome;
	@Column(nullable = true, length = 100)
	private String cpf;
	@Column(nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 100)
	private String password;
	@Column(nullable = true, length = 100)
	private String logradouro;
	@Column(nullable = true, length = 100)
	private String cep;
	@Column(nullable = true, length = 100)
	private String bairro;
	@Column(nullable = true, length = 100)
	private String cidade;
	@Column(nullable = true, length = 100)
	private String uf;
	private boolean codStatus;
	@Column(nullable = true, length = 100)
	private String tipo_usuario;
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Telefone> telefones = new ArrayList<>();
	
	
	@Transient
	private String mensagemErro = "";
	@Transient
	private boolean isValid = true;
	
	//set and get
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public boolean isCodStatus() {
		return codStatus;
	}
	public void setCodStatus(boolean cod_status) {
		this.codStatus = cod_status;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	//Validação
	
	public boolean validarUsuario() {
		if(email == null || email.isEmpty()) {
			mensagemErro += "O email é obrigatório:";
			isValid = false;
		}
		if(password == null || password.isEmpty()) {
			mensagemErro += "A senha é obrigatória:";
			isValid = false;
		
		
		}
		return isValid;
	}
}
	
		
	
