package com.itb.mif3an.pizzariabomgosto.model.entity;

import java.time.LocalDateTime;
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
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,length = 15)
	private String numeroPedido;
	private LocalDateTime dataHoraCompra;
	private LocalDateTime dataHoraEntrega;
	@Column(nullable = true,columnDefinition = "DECIMAL(5,2)")
	private double valorTotal;
	@Column(nullable = false,length = 20)
	private String status;
	private boolean codStatus;
	
	@Transient
	private String mensagemErro = "";
	@Transient
	private boolean isValid = true;

	
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ItemPedido> itenspedido = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumeroPedido() {
		return numeroPedido;
	}


	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}


	public LocalDateTime getDataHoraCompra() {
		return dataHoraCompra;
	}


	public void setDataHoraCompra(LocalDateTime dataHoraCompra) {
		this.dataHoraCompra = dataHoraCompra;
	}


	public LocalDateTime getDataHoraEntrega() {
		return dataHoraEntrega;
	}


	public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isCodStatus() {
		return codStatus;
	}


	public void setCodStatus(boolean codStatus) {
		this.codStatus = codStatus;
	}


	public List<ItemPedido> getItenspedido() {
		return itenspedido;
	}


	public void setItenspedido(List<ItemPedido> itenspedido) {
		this.itenspedido = itenspedido;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	public boolean validarPedido() {
		
		return isValid;
	}
	
}
