package ar.edu.utn.link.integrador.app.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import ar.edu.utn.link.integrador.model.Producto;
import ar.edu.utn.link.integrador.model.Proveedor;

public interface VendedorDTO {
String getNombre();
	
	List<Proveedor> getProveedores();
	
	List<Producto> getProductos();
	
	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();
	

}
