package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.utn.link.integrador.app.TipoDocumento;

public class Cliente {
	private String idCliente;
	private String nombre;
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private LocalDate fechaDeNacimiento;
	//private ArrayList<MedioDePago2> mediosDePago;
	private Carrito carritoDeCompras;
	private boolean esMiembro;
	private ArrayList<OrdenDeCompra> comprasRealizadas;
	private ArrayList<Promocion> promociones;

	public Cliente(String idCliente, String nombre, TipoDocumento tipoDocumento, String nroDocumento,
			LocalDate fechaDeNacimiento, Carrito carritoDeCompras, boolean esMiembro,
			ArrayList<Promocion> promociones) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.carritoDeCompras = carritoDeCompras;
		this.esMiembro = esMiembro;
		this.promociones = promociones;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public ArrayList<OrdenDeCompra> getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setComprasRealizadas(ArrayList<OrdenDeCompra> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}

	public Carrito getCarritoDeCompras() {
		return carritoDeCompras;
	}

	public void setCarritoDeCompras(Carrito carritoDeCompras) {
		this.carritoDeCompras = carritoDeCompras;
	}

	public boolean EsMiembro() {
		return esMiembro;
	}

	public void setEsMiembro(boolean esMiembro) {
		this.esMiembro = esMiembro;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void agregarACarrito(ItemCarrito unItem) {
		carritoDeCompras.agregarProducto(unItem);
	}

	public OrdenDeCompra finalizarCompra(MedioDePago unMedio,Membresia membresia,Cupon unCupon) {
		this.aplicarMedioDePago(unMedio);
		this.CompraSegunMembresia(membresia);
		this.aplicarCupon(unCupon);
		OrdenDeCompra orden = new OrdenDeCompra(1, LocalDate.now(), carritoDeCompras.getSubtotal());
		comprasRealizadas.add(orden);
		return orden;
	    //carritoDeCompras.vaciarCarrito();
	}
	
	public void aplicarMedioDePago(MedioDePago unMedio) {
		carritoDeCompras.aplicarPromocion(unMedio);
	}
	
	public void CompraSegunMembresia(Membresia membresia) {
		carritoDeCompras.aplicarPromocion(membresia);
	}
	
	public void aplicarCupon(Cupon unCupon) {
		carritoDeCompras.aplicarPromocion(unCupon);
		promociones.remove(unCupon);
	}
	
	

}
