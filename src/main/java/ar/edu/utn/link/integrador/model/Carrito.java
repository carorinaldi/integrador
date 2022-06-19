package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Carrito {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	private List<ItemCarrito> itemsCarrito;
	
	private double subtotal;
	
	@ManyToMany
	private List<Promocion> promociones;

	public Carrito(List<ItemCarrito> items) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito(Integer id, List<ItemCarrito> itemsCarrito, double subtotal, List<Promocion> promociones) {
		super();
		this.id = id;
		this.itemsCarrito = itemsCarrito;
		this.subtotal = subtotal;
		this.promociones=promociones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ItemCarrito> getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void agregarProducto(ItemCarrito unItem) throws NoHayStockException {
		//itemsCarrito.add(unItem);
		unItem.serAgregado(this);
		subtotal += unItem.precio();
	}
	
	public void quitarProducto(ItemCarrito unItem) {
		unItem.serQuitado(this);
		subtotal -= unItem.precio();
	}
	
	public void agregarPromocion(Promocion promocion) {
		promociones.add(promocion);
	}
	
	public OrdenDeCompra terminarCompra() {
		itemsCarrito.forEach(item->item.getProducto().reducirStock(item.getCantidad()));
		return new OrdenDeCompra(LocalDate.now(), subtotal, this.precioTotal());
		
	}
	
	public double precioTotal() { 
		if(promociones.size()>0) {
			return subtotal - promociones.stream().mapToDouble(promo->{
				try {
					return promo.aplicarPromocion(this);
				} catch (NoSePuedeAplicarCuponException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return subtotal;
			}).sum();
		} else {
			return subtotal;
		}
	}
	
	public void aplicarPromocion(Promocion unaPromocion) throws NoSePuedeAplicarCuponException {
		subtotal *= 1 - unaPromocion.descuento();

	}

	public void vaciarCarrito() {
		itemsCarrito.clear();
	}

}
