package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrdenDeCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDate fecha;
	private double subtotal;
	private double total;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public OrdenDeCompra(LocalDate fecha, double subtotal, double total) {
		super();
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.total = total;
	}

	public OrdenDeCompra(LocalDate fecha, double total) {
		super();
		this.fecha = fecha;
		this.total = total;
	}

	public OrdenDeCompra() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
