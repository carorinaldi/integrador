package ar.edu.utn.link.integrador.app.dtos;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.integrador.model.ItemCarrito;

public interface OrdenDeCompraDTO {
	LocalDate getFecha();
	
	@Value("#{target.items")
	Collection<ItemCarrito> getItems();
	
	@Value("#{target.items.size()")
	int cantItems();
	
	double getSubtotal();
	
	double getTotal();
}
