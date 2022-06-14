package ar.edu.utn.link.integrador.model;

public class Usuario {
	private String nombreUsuario;
	private String email;
	private String password;
	private Rol rol;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario(String nombreUsuario, String email, String password, Rol rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

}
