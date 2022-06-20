package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

public class Cupon extends Promocion {
	private String codigoCupon;
	private LocalDate fechaVencimiento;
	private boolean fueUsado;
	private double descuento;
	private Proveedor proveedor;

	public Cupon(String codigoCupon, LocalDate fechaVencimiento, boolean fueUsado, double descuento,
			Proveedor proveedor) {
		super();
		this.codigoCupon = codigoCupon;
		this.fechaVencimiento = fechaVencimiento;
		this.fueUsado = fueUsado;
		this.descuento = descuento;
		this.proveedor = proveedor;
	}

	public String getCodigoCupon() {
		return codigoCupon;
	}

	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isFueUsado() {
		return fueUsado;
	}

	public void setFueUsado(boolean fueUsado) {
		this.fueUsado = fueUsado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void usarCupon() {
		fueUsado = true;
	}

	public double descuento() throws NoSePuedeAplicarCuponException {
		if (this.fechaVencimiento.compareTo(LocalDate.now()) < 0) {
			if (fueUsado)
				throw new NoSePuedeAplicarCuponException("no se puede aplicar cupon porque ya fue usado");
			else
				throw new NoSePuedeAplicarCuponException("no se puede aplicar cupon porque venció");
		}
		return descuento;
	}
	
	

	@Override
	public double aplicarPromocion(Carrito unCarrito) throws NoSePuedeAplicarCuponException {
		unCarrito.contiene(proveedor);
		this.usarCupon();
		return unCarrito.getSubtotal() * (1 - this.descuento());
	}

}
