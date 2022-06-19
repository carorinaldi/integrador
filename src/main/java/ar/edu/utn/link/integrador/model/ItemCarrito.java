package ar.edu.utn.link.integrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemCarrito {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private Producto producto;
	
	private int cantidad;

	double precio() {
		return producto.getPrecio() * cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ItemCarrito(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public void serAgregado(Carrito carrito) throws NoHayStockException {
		if(producto.getStock()<cantidad) {
			throw new NoHayStockException("El producto se encuentra sin stock");
		}
		carrito.getItemsCarrito().add(this);
	}

	public void serQuitado(Carrito carrito) {
		producto.agregarStock(cantidad);
		
	}

}
