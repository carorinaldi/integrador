package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToMany
	private Collection<ItemCarrito> itemsCarrito;

	private double subtotal;

	@ManyToMany
	private Collection<Promocion> promociones;

	public Carrito(List<ItemCarrito> items) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito(Collection<ItemCarrito> itemsCarrito, double subtotal, Collection<Promocion> promociones) {
		this.itemsCarrito = itemsCarrito;
		this.subtotal = subtotal;
		this.promociones = promociones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<ItemCarrito> getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(Collection<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Collection<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void agregarProducto(ItemCarrito unItem) throws NoHayStockException {
		if (unItem.getProducto().getStock() < unItem.getCantidad()) {
			throw new NoHayStockException("El producto se encuentra sin stock");
		}
		itemsCarrito.add(unItem);
		subtotal += unItem.precio();
	}

	public void quitarProducto(ItemCarrito unItem) {
		itemsCarrito.remove(unItem);
		subtotal -= unItem.precio();
	}

	public void agregarPromocion(Promocion promocion) {
		promociones.add(promocion);
	}

	public OrdenDeCompra terminarCompra() {
		itemsCarrito.forEach(item -> item.getProducto().reducirStock(item.getCantidad()));
		return new OrdenDeCompra(LocalDate.now(), itemsCarrito, subtotal, this.precioTotal());

	}

	public double precioTotal() {
		if (promociones.size() > 0) {
			return promociones.stream().mapToDouble(promo -> {
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

	public void contiene(Proveedor proveedor) {
		itemsCarrito.stream().map(item -> item.getProducto().getProveedor()).anyMatch(x -> x.equals(proveedor));
	}

	public void vaciarCarrito() {
		itemsCarrito.clear();
	}


}
