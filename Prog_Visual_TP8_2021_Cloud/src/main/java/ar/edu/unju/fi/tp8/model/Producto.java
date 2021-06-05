package ar.edu.unju.fi.tp8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "pro_codigo")
	private int codigo;
	
	@Column(name = "pro_nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "pro_precio", nullable = false)
	private double precio;
	
	@Column(name = "pro_marca", nullable = false, length = 80)
	private String marca;
	
	@Column(name = "pro_stock", nullable = false)
	private int stock;
	
	/* Constructor por defecto*/
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	
	public Producto(int codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}



	/*Getter y Setters de los atributos privados*/
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca="
				+ marca + ", stock=" + stock + "]";
	}


	
	
	
	
	

}
