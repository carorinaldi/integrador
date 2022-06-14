package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

public class Cupon extends Promocion {
	private String codigoCupon;
	private LocalDate fechaVencimiento;
	private boolean fueUsado; 

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

//	public void usarCupon() throws Exception {
//		if(fueUsado==true) throw new Exception("no se puede aplicar cupon porque ya fue usado");
//		else {
//			fueUsado=true;
//			}
//	}
	
	public double descuento(){
		if(this.fechaVencimiento.compareTo(LocalDate.now())>0) {
			return 0.15;
		} else return 0;
	}
	
}
