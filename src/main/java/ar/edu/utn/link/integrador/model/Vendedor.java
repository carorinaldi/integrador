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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Vendedor {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String apellido;
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private LocalDate fechaDeNacimiento;
	private RolNombre rol = RolNombre.VENDEDOR;
	
	@OneToMany
	private List<Proveedor> proveedores;
	
	@OneToMany
	private List<OrdenDeCompra> ordenes;
	
	@OneToMany
	private List<Producto> productos;
	

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Vendedor(String nombre, String apellido, TipoDocumento tipoDocumento, String nroDocumento,
			LocalDate fechaDeNacimiento, List<Proveedor> proveedores, List<OrdenDeCompra> ordenes,
			List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.proveedores = proveedores;
		this.ordenes = ordenes;
		this.productos = productos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public List<OrdenDeCompra> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<OrdenDeCompra> ordenes) {
		this.ordenes = ordenes;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public RolNombre getRol() {
		return rol;
	}



	public void setRol(RolNombre rol) {
		this.rol = rol;
	}

	


//	void vincularse(Proveedor proveedor) {
//		proveedores.add(proveedor);
//	}
//	
//	void desvincularse(Proveedor proveedor) {
//		proveedores.remove(proveedor);
//	}
}
