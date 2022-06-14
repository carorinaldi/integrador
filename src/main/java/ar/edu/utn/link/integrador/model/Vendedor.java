package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vendedor extends Rol {
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private LocalDate fechaDeNacimiento;
	private ArrayList<Proveedor> proveedores;
	private OrdenDeCompra ordenes;
	private ArrayList<Producto> productos;

	
	public Vendedor(String nombre, String apellido, TipoDocumento tipoDocumento, String nroDocumento,
			LocalDate fechaDeNacimiento, ArrayList<Proveedor> proveedores, OrdenDeCompra ordenes,
			ArrayList<Producto> productos) {
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

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendedor(Integer id) {
		super(id);
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

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public OrdenDeCompra getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(OrdenDeCompra ordenes) {
		this.ordenes = ordenes;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

//	void vincularse(Proveedor proveedor) {
//		proveedores.add(proveedor);
//	}
//	
//	void desvincularse(Proveedor proveedor) {
//		proveedores.remove(proveedor);
//	}
}
