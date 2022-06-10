package ar.edu.utn.link.integrador.model;

public class Membresia implements Promocion{
	private Cliente unCliente;

	public Membresia(Cliente unCliente) {
		super();
		this.unCliente = unCliente;
	}
	
	public double descuento() {
		if(unCliente.EsMiembro()) {
			return 0.18;
		} else {return 0;}
	}
}
