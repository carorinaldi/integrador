package ar.edu.utn.link.integrador.app;

import ar.edu.utn.link.integrador.model.Producto;

public class ProductoRepetidoException extends Exception {
	private Producto producto;

	public ProductoRepetidoException(Producto producto) {
		super();
		this.producto = producto;
	}
	
}
