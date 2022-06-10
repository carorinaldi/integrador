package ar.edu.utn.link.integrador.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.edu.utn.link.integrador.model.Producto;

@Repository
public class RepoProductoMem {
	private Collection<Producto> productos;

	public RepoProductoMem() {
		super();
		List<Producto> of = List.of(new Producto("1","SmartTV",20000),new Producto("2","Notebook Dell",50000),new Producto("3","Calculadora",500),new Producto("2","Notebook Dell",50000),new Producto("4","SmartWatch",500));
		productos = new ArrayList<Producto>(of);
	}
	
	public Collection<Producto> all(){
		return productos;
	}

	public Producto findByName(String nombreProducto) {
		return productos.stream().filter(producto->producto.getNombre().equals(nombreProducto)).findFirst().get();
	}

	public Collection<Producto> findByPrice(Integer precio) {
		return productos.stream().filter(producto->producto.getPrecio()==precio).collect(Collectors.toList());
	}

	public void save(Producto producto) throws ProductoRepetidoException {
		
		if(productos.contains(producto)) {
			throw new ProductoRepetidoException(producto);
		}
		this.productos.add(producto);
	}
	
}
