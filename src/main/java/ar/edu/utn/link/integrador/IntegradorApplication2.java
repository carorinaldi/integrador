package ar.edu.utn.link.integrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.utn.link.integrador.app.TipoDocumento;
import ar.edu.utn.link.integrador.model.Carrito;
import ar.edu.utn.link.integrador.model.Cliente;
import ar.edu.utn.link.integrador.model.Cupon;
import ar.edu.utn.link.integrador.model.ItemCarrito;
import ar.edu.utn.link.integrador.model.MedioDePago;
import ar.edu.utn.link.integrador.model.Membresia;
import ar.edu.utn.link.integrador.model.MetodoDePago;
import ar.edu.utn.link.integrador.model.OrdenDeCompra;
import ar.edu.utn.link.integrador.model.Producto;
import ar.edu.utn.link.integrador.model.Promocion;

@SpringBootApplication
public class IntegradorApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorApplication.class, args);

		Carrito carrito1 = new Carrito(new ArrayList<ItemCarrito>());

		Cupon cupon1 = new Cupon("123abc", LocalDate.of(2022, 10, 30));
		ArrayList<Promocion> cupones = new ArrayList<>();
		cupones.add(cupon1);
		Cliente carolina = new Cliente("1", "Carolina", TipoDocumento.DNI, "33996507", LocalDate.of(1988, 9, 10),
				carrito1, true, cupones);

		Producto smartTv = new Producto("1", "SmartTV", 20000);
		Producto notebook = new Producto("2", "Notebook Dell", 50000);
		Producto calculadora = new Producto("3", "Calculadora", 500);
		Producto reloj = new Producto("4", "SmartWatch", 500);

//		carrito1.agregarProducto(new ItemCarrito(smartTv, 3));
//		carrito1.agregarProducto(new ItemCarrito(notebook,1));
		carolina.agregarACarrito(new ItemCarrito(smartTv, 3));
		carolina.agregarACarrito(new ItemCarrito(notebook, 1));
		carolina.agregarACarrito(new ItemCarrito(calculadora, 1));
		carolina.agregarACarrito(new ItemCarrito(reloj, 1));

		System.out.println(carolina.getCarritoDeCompras().getItemsCarrito().size());
		System.out.println(carolina.getCarritoDeCompras().getSubtotal());
		System.out.println(20000 * 3 + 50000 + 500 + 500);
		
		MedioDePago metodo = new MedioDePago(MetodoDePago.EFECTIVO);
		carolina.aplicarMedioDePago(metodo);
		System.out.println(carolina.getCarritoDeCompras().getSubtotal());
		carolina.CompraSegunMembresia(new Membresia(carolina));
		System.out.println(carolina.getCarritoDeCompras().getSubtotal());
		carolina.aplicarCupon(cupon1);
		System.out.println(carolina.getCarritoDeCompras().getSubtotal());
		System.out.println(cupon1.descuento());
//		OrdenDeCompra orden = carolina.finalizarCompra();
//		System.out.println(
//				"se genero la nueva orden con fecha " + orden.getFecha() + " y monton total: $" + orden.getMonto());

	}

}
