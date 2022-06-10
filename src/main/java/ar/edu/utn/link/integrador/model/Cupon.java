package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

public class Cupon implements Promocion {
	private String codigoCupon;
	private LocalDate fechaVencimiento;

	public Cupon(String codigoCupon, LocalDate fechaVencimiento) {
		super();
		this.codigoCupon = codigoCupon;
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCodigoCupon() {
		return codigoCupon;
	}

	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}
	
	public double descuento(){
		if(this.fechaVencimiento.compareTo(LocalDate.now())>0) {
			return 0.15;
		} else return 0;
	}
	
}
