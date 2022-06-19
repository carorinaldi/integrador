package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String apellido;
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private LocalDate fechaDeNacimiento;
	private RolNombre rol = RolNombre.ADMINISTRADOR;
//	private List<Promocion> promociones;
//	private List <Vendedor> vendedores;
//	private List <Cliente> clientes;

	public Administrador() {
	}

	public Administrador(String nombre, String apellido, TipoDocumento tipoDocumento, String nroDocumento,
			LocalDate fechaDeNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.fechaDeNacimiento = fechaDeNacimiento;
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

	public RolNombre getRol() {
		return rol;
	}

}
