package ar.edu.utn.link.integrador.app.dtos;

import ar.edu.utn.link.integrador.model.Proveedor;

public interface ProductoDTO {
	String getNombre();
	
	double getPrecio();
	
	Proveedor getProveedor(); 
	
	int getStock();
	
	String getImagen();

}
