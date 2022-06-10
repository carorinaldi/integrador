package ar.edu.utn.link.integrador.model;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<ItemCarrito> itemsCarrito;
	private double subtotal;

	public Carrito(ArrayList<ItemCarrito> itemsCarrito) {
		super();
		this.itemsCarrito = itemsCarrito;
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
