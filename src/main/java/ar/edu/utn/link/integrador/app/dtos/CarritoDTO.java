package ar.edu.utn.link.integrador.app.dtos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.integrador.model.Cliente;
import ar.edu.utn.link.integrador.model.ItemCarrito;
import ar.edu.utn.link.integrador.model.Promocion;

public interface CarritoDTO {
	
	//@Value("#{target.itemsCarrito")
	Collection<ItemCarrito> getItemsCarrito();
	
	double getSubtotal();
	
//	@Value("#{target.promociones")
	Collection<Promocion> getPromociones();
	
	
	

}
