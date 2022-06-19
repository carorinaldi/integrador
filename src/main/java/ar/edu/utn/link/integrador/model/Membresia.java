package ar.edu.utn.link.integrador.model;

public class Membresia extends Promocion{
	private Cliente unCliente;
	private double descuento;

	public Membresia(Cliente unCliente) {
		super();
		this.unCliente = unCliente;
	}
	
	public double descuento() {
		if(unCliente.EsMiembro()) {
			return descuento;
		} else {return 0;}
	}

	public Cliente getUnCliente() {
		return unCliente;
	}

	public void setUnCliente(Cliente unCliente) {
		this.unCliente = unCliente;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
