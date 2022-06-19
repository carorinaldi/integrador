package ar.edu.utn.link.integrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public abstract double descuento() throws NoSePuedeAplicarCuponException;
	
	public double aplicarPromocion(Carrito unCarrito) throws NoSePuedeAplicarCuponException {
		return unCarrito.getSubtotal() - unCarrito.getSubtotal()*this.descuento();
	}
}


