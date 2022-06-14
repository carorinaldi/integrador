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
	private double monto;
	// private int codPago;
	// private String Estado; // puede ser un ENUM

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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public OrdenDeCompra(Integer id, LocalDate fecha, double monto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
	}

	public OrdenDeCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public int getCodPago() { return codPago; } public void setCodPago(int
	 * codPago) { this.codPago = codPago; } public String getEstado() { return
	 * Estado; } public void setEstado(String estado) { Estado = estado; }
	 */
	

}
