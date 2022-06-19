package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

public class Cupon extends Promocion {
	private String codigoCupon;
	private LocalDate fechaVencimiento;
	private boolean fueUsado;
	private double descuento;

	public Cupon(String codigoCupon, LocalDate fechaVencimiento, boolean fueUsado) {
		super();
		this.codigoCupon = codigoCupon;
		this.fechaVencimiento = fechaVencimiento;
		this.fueUsado = fueUsado;
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
		this.usarCupon();
		return super.aplicarPromocion(unCarrito);
	}
}
