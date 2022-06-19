package ar.edu.utn.link.integrador.model;

public class MedioDePago extends Promocion {

	private MetodoDePago metodo;
	private double descuento;

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
	
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public double descuento() {
		return descuento;
	}
	
// podria predeterminar cuanto es el porcentaje de descuento segun el medio con el metodo comentado de abajo:	
//
//	public double descuento() {
//		switch (metodo) {
//		case CREDITO:
//			return 0.20;
//		case DEBITO:
//			return 0.05;
//		case EFECTIVO:
//			return 0.25;
//		default:
//			return 0.00;
//		}
//	}

}
