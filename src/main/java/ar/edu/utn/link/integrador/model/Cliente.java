package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank
	private String nombre;
	private String apellido;

	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	private String nroDocumento;
	private LocalDate fechaDeNacimiento;

	@OneToOne
	private Carrito carritoDeCompras;
	private boolean esMiembro;

	@OneToMany
	private List<OrdenDeCompra> comprasRealizadas;
	private RolNombre rol = RolNombre.CLIENTE;

	public Cliente(@NotBlank String nombre, String apellido, TipoDocumento tipoDocumento, String nroDocumento,
			LocalDate fechaDeNacimiento, Carrito carritoDeCompras, boolean esMiembro,
			List<OrdenDeCompra> comprasRealizadas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.carritoDeCompras = carritoDeCompras;
		this.esMiembro = esMiembro;
		this.comprasRealizadas = comprasRealizadas;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public List<OrdenDeCompra> getComprasRealizadas() {
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
		return true;
	}

	public boolean isEsMiembro() {
		return esMiembro;
	}

	public void setEsMiembro(boolean esMiembro) {
		this.esMiembro = esMiembro;
	}

	public RolNombre getRol() {
		return rol;
	}

	public void setRol(RolNombre rol) {
		this.rol = rol;
	}

	public void agregarACarrito(ItemCarrito unItem) throws NoHayStockException {
		carritoDeCompras.agregarProducto(unItem);
	}

	public void finalizarCompra() {
		OrdenDeCompra orden = carritoDeCompras.terminarCompra();
		comprasRealizadas.add(orden);
		carritoDeCompras.vaciarCarrito();
	}

//	public void aplicarMedioDePago(MedioDePago unMedio) {
//		carritoDeCompras.aplicarPromocion(unMedio);
//	}
//
//	public void CompraSegunMembresia(Membresia membresia) {
//		carritoDeCompras.aplicarPromocion(membresia);
//	}
//
//	public void aplicarCupon(Cupon unCupon) {
//		// unCupon.usarCupon();
//		carritoDeCompras.aplicarPromocion(unCupon);
//		//promociones.remove(unCupon);
//	}

}
