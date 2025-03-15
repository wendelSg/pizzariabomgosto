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
public class ItemPedido {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int quantidadeItem;
	@Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
	private double precoUnitario;
	private boolean codStatus;
	
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = true)
	private Pedido pedido;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = true)
	private Produto produto;
	
	
	@Transient			/*<--Não é coluna*/
	private String mensagemErro = "";
	@Transient
	private boolean isValid = true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidadeItem() {
		return quantidadeItem;
	}
	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public boolean isCodStatus() {
		return codStatus;
	}
	public void setCodStatus(boolean codStatus) {
		this.codStatus = codStatus;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
public boolean validarItemPedido() {
		
		return isValid;
	}
}
