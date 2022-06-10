package ar.edu.utn.link.integrador.model;

import java.util.ArrayList;

public class Vendedor {
	private String nombre;
	private ArrayList<Proveedor> proveedores;
	private OrdenDeCompra ordenes;
	private Producto productos;
	
	void vincularse(Proveedor proveedor) {
		proveedores.add(proveedor);
	}
	
	void desvincularse(Proveedor proveedor) {
		proveedores.remove(proveedor);
	}
}
