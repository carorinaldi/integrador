package ar.edu.utn.link.integrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String razonSocial;
	private String direccion;
	private String cuit;
	private String telefono;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Proveedor( String razonSocial, String direccion, String cuit, String telefono, String email) {
		super();
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cuit = cuit;
		this.telefono = telefono;
		this.email = email;
	}

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
