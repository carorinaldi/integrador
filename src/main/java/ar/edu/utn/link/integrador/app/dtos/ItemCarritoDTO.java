package ar.edu.utn.link.integrador.app.dtos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.integrador.model.Cliente;
import ar.edu.utn.link.integrador.model.ItemCarrito;
import ar.edu.utn.link.integrador.model.Producto;
import ar.edu.utn.link.integrador.model.Promocion;

public interface ItemCarritoDTO {
	
	Integer getId();
	

	Producto getProducto();
	
	int getCantidad();
	
	
}
