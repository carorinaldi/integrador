package ar.edu.utn.link.integrador.app.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.integrador.model.Carrito;
import ar.edu.utn.link.integrador.model.OrdenDeCompra;

public interface ClienteDTO {
	
	String getNombre();
	
	Carrito getCarritoDeCompras();
	
	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();
	
	//@Value("#{target.comprasRealizadas.size()")
	//int cantComprasRealizadas();
	
	@Value("#{target.comprasRealizadas}")
	List<OrdenDeCompra> getComprasRealizadas();
}
