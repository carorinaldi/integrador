package ar.edu.utn.link.integrador.model;

import java.time.LocalDate;
import java.util.List;

public class Administrador extends Rol {
	
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private LocalDate fechaDeNacimiento;
	private List<Promocion> promociones;
	private List <Vendedor> vendedores;
	private List <Cliente> clientes;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

}
