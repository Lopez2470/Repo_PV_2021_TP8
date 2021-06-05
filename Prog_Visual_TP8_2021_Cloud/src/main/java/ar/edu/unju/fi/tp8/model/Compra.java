package ar.edu.unju.fi.tp8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COMPRAS")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Producto producto;
	
	@Column(name = "com_cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "com_total", nullable = false)
	private double total;

	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Compra(int id, Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getTotal() {
		this.total = this.producto.getPrecio() * this.cantidad;
		return this.total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	/*
	public double obtenerCalculoTotal() {
		double total = cantidad*producto.getPrecio();
		return total;
	}
	*/
}
