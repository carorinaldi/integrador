package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

public class OrdenDeCompra {
	private int codigoDeCompra;
	private LocalDate fecha;
	private double monto;
	//private int codPago;
	//private String Estado; // puede ser un ENUM
	
	public int getCodigoDeCompra() {
		return codigoDeCompra;
	}
	public void setCodigoDeCompra(int codigoDeCompra) {
		this.codigoDeCompra = codigoDeCompra;
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
	/*public int getCodPago() {
		return codPago;
	}
	public void setCodPago(int codPago) {
		this.codPago = codPago;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}*/
	public OrdenDeCompra(int codigoDeCompra, LocalDate fecha, double monto/* int codPago, String estado*/) {
		super();
		this.codigoDeCompra = codigoDeCompra;
		this.fecha = fecha;
		this.monto = monto;
		//this.codPago = codPago;
		//Estado = estado;
	}
	
}
