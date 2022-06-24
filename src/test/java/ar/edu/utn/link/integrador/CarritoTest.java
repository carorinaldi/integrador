package ar.edu.utn.link.integrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;



import org.junit.jupiter.api.Test;

import ar.edu.utn.link.integrador.model.Carrito;
import ar.edu.utn.link.integrador.model.Cliente;
import ar.edu.utn.link.integrador.model.Cupon;
import ar.edu.utn.link.integrador.model.ItemCarrito;
import ar.edu.utn.link.integrador.model.MedioDePago;
import ar.edu.utn.link.integrador.model.Membresia;
import ar.edu.utn.link.integrador.model.MetodoDePago;
import ar.edu.utn.link.integrador.model.NoHayStockException;
import ar.edu.utn.link.integrador.model.OrdenDeCompra;
import ar.edu.utn.link.integrador.model.Producto;
import ar.edu.utn.link.integrador.model.Promocion;
import ar.edu.utn.link.integrador.model.Proveedor;
import ar.edu.utn.link.integrador.model.TipoDocumento;

public class CarritoTest {
	@Test
	public void CalcularPrecioTotalSinPromocionTest() throws NoHayStockException {
		Proveedor samsung = new Proveedor("Samsung", "Florida 731, C1054 CABA", "30-68412579-2", "0800-555-7267",
				"samsung@samsung.com");
		Proveedor casio = new Proveedor("Casio", "Av. Corrientes 456 Oficina 64, C1043 CABA", "30-86411111-4",
				"011 5252-3434", "casio@casio.com");

		Producto notebook = new Producto("Notebook Dell", 50000.0, samsung, 5,"linkImagen");
		Producto calculadora = new Producto("Calculadora", 500.0, casio, 20,"linkImagen");
		Producto reloj = new Producto("SmartWatch", 500.0, samsung, 8,"linkImagen");
		
		Carrito carrito1 = new Carrito(new ArrayList<ItemCarrito>(), 0, new ArrayList<Promocion>());
		carrito1.agregarProducto(new ItemCarrito(calculadora, 2));
		carrito1.agregarProducto(new ItemCarrito(notebook, 1));
		carrito1.agregarProducto(new ItemCarrito(reloj,3));
		
		assertEquals(carrito1.getItemsCarrito().size(), 3);
		assertEquals(carrito1.precioTotal(), 52500.0);
	}

	@Test
	public void CalcularPrecioTotalConPromoCuponTest() throws NoHayStockException {

		Proveedor samsung = new Proveedor("Samsung", "Florida 731, C1054 CABA", "30-68412579-2", "0800-555-7267",
				"samsung@samsung.com");

		Producto notebook = new Producto("Notebook Dell", 50000.0, samsung, 5,"linkImagen");

		Promocion cupon = new Cupon("123123", LocalDate.of(2022, 10, 30), false, 0.1,samsung);
		
		Collection<Promocion> promociones = new ArrayList<Promocion>();
		Cliente carolina = new Cliente("Carolina", "Rinaldi", TipoDocumento.DNI, "33334432", 
				LocalDate.of(1988, 10, 30), new Carrito() , true, new ArrayList<OrdenDeCompra>());
		Carrito carrito1 = new Carrito(new ArrayList<ItemCarrito>(), 0, promociones);
		
		carrito1.agregarProducto(new ItemCarrito(notebook, 1));
		carrito1.agregarPromocion(cupon);
		assertEquals(carrito1.precioTotal(), 45000.0);
		
	}
	
	@Test
	public void CalcularPrecioTotalConPromoMedioDePagoTest() throws NoHayStockException {

		Proveedor samsung = new Proveedor("Samsung", "Florida 731, C1054 CABA", "30-68412579-2", "0800-555-7267",
				"samsung@samsung.com");

		Producto smartTv = new Producto("SmartTV", 20000.0, samsung, 10,"linkImagen");
		
		Promocion debito = new MedioDePago(MetodoDePago.DEBITO, 0.15);
		
		Collection<Promocion> promociones = new ArrayList<Promocion>();
		Cliente carolina = new Cliente("Carolina", "Rinaldi", TipoDocumento.DNI, "33334432", 
				LocalDate.of(1988, 10, 30), new Carrito() , true, new ArrayList<OrdenDeCompra>());
		Carrito carrito1 = new Carrito( new ArrayList<ItemCarrito>(), 0, promociones);
		
		
		carrito1.agregarProducto(new ItemCarrito(smartTv, 1));
		carrito1.agregarPromocion(debito);
		assertEquals(carrito1.precioTotal(), 17000.0);
		
	}
	
	@Test
	public void CalcularPrecioTotalConMembresiaTest() throws NoHayStockException {

		Proveedor samsung = new Proveedor("Samsung", "Florida 731, C1054 CABA", "30-68412579-2", "0800-555-7267",
				"samsung@samsung.com");
		Proveedor casio = new Proveedor("Casio", "Av. Corrientes 456 Oficina 64, C1043 CABA", "30-86411111-4",
				"011 5252-3434", "casio@casio.com");

		Producto smartTv = new Producto("SmartTV", 20000.0, samsung, 10,"linkImagen");
		Producto notebook = new Producto("Notebook Dell", 50000.0, samsung, 5,"linkImagen");
		Producto calculadora = new Producto("Calculadora", 500.0, casio, 20,"linkImagen");
		Producto reloj = new Producto("SmartWatch", 500.0, samsung, 8,"linkImagen");

		
		Collection<Promocion> promociones = new ArrayList<Promocion>();
		Cliente carolina = new Cliente("Carolina", "Rinaldi", TipoDocumento.DNI, "33334432", 
				LocalDate.of(1988, 10, 30), new Carrito() , true, new ArrayList<OrdenDeCompra>());
		Carrito carrito1 = new Carrito(new ArrayList<ItemCarrito>(), 0, promociones);
		
		
		Promocion membresiaPlata = new Membresia(carolina, 0.20);
		
		carrito1.agregarProducto(new ItemCarrito(smartTv, 1));
		carrito1.agregarProducto(new ItemCarrito(notebook, 1));
		carrito1.agregarProducto(new ItemCarrito(calculadora,1));
		carrito1.agregarProducto(new ItemCarrito(reloj,1));
		
		carrito1.agregarPromocion(membresiaPlata);
		assertEquals(carrito1.precioTotal(), 56800.0);
		
	}

}
