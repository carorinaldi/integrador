package ar.edu.utn.link.integrador.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private ArrayList<ItemCarrito> itemsCarrito;
	private double subtotal;

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito(Integer id, ArrayList<ItemCarrito> itemsCarrito, double subtotal) {
		super();
		this.id = id;
		this.itemsCarrito = itemsCarrito;
		this.subtotal = subtotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<ItemCarrito> getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(ArrayList<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public void agregarProducto(ItemCarrito unItem) {
		itemsCarrito.add(unItem);
		subtotal += unItem.precio();
	}


	// para precioTotal() { return itemsCarrito.stream().mapToDouble(item ->
	// item.precio()).sum();}
	
	
	
	public void aplicarPromocion(Promocion unaPromocion) {
		subtotal*= 1 - unaPromocion.descuento();

	}
	
	public void vaciarCarrito() {
		itemsCarrito.clear();
	}
	

}
