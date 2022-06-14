package ar.edu.utn.link.integrador.model;

public class MedioDePago extends Promocion {

	MetodoDePago metodo;

	public MedioDePago(MetodoDePago metodo) {
		super();
		this.metodo = metodo;
	}

	public MetodoDePago getMetodo() {
		return metodo;
	}

	public void setMetodo(MetodoDePago metodo) {
		this.metodo = metodo;
	}

	public double descuento() {

		switch (metodo) {
		case CREDITO:
			return 0.20;
		case DEBITO:
			return 0.05;
		case EFECTIVO:
			return 0.25;
		default:
			return 0.00;
		}

	}
}
