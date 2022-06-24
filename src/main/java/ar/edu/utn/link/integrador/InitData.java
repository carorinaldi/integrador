package ar.edu.utn.link.integrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import ar.edu.utn.link.integrador.app.RepoCarrito;
import ar.edu.utn.link.integrador.app.RepoCliente;
import ar.edu.utn.link.integrador.app.RepoItemCarrito;
import ar.edu.utn.link.integrador.app.RepoProducto;
import ar.edu.utn.link.integrador.app.RepoProveedor;
import ar.edu.utn.link.integrador.model.Carrito;
import ar.edu.utn.link.integrador.model.Cliente;
import ar.edu.utn.link.integrador.model.ItemCarrito;
import ar.edu.utn.link.integrador.model.OrdenDeCompra;
import ar.edu.utn.link.integrador.model.Producto;
import ar.edu.utn.link.integrador.model.Promocion;
import ar.edu.utn.link.integrador.model.Proveedor;
import ar.edu.utn.link.integrador.model.TipoDocumento;


@Component
public class InitData implements CommandLineRunner {
 
	@Autowired
	RepoProducto repoProducto;
	
	@Autowired
	RepoProveedor repoProveedor;
	
	@Autowired
	RepoCliente repoCliente;
	
	@Autowired
	RepoItemCarrito repoItemCarrito;
	
	@Autowired
	RepoCarrito repoCarrito;
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		//config.getProjectionConfiguration().addProjection(ProductoDTO.class);
		config.exposeIdsFor(Producto.class,Proveedor.class);
		if(repoProducto.count() == 0) {
			
			Carrito carrito1 = new Carrito(new ArrayList<ItemCarrito>(), 0, new ArrayList<Promocion>());
			Carrito carrito2 = new Carrito(new ArrayList<ItemCarrito>(), 0, new ArrayList<Promocion>());
			Carrito carrito3 = new Carrito(new ArrayList<ItemCarrito>(), 0, new ArrayList<Promocion>());
			
			List<Carrito> carritosIciales = List.of(carrito1,carrito2,carrito3);
			
			carritosIciales.stream().forEach(carrito->{
				repoCarrito.save(carrito);
			});
			
			Cliente carolina = new Cliente("Carolina", "Rinaldi", TipoDocumento.DNI, "33334432", 
					LocalDate.of(1988, 10, 30), carrito1 , true, new ArrayList<OrdenDeCompra>());
			
			Cliente merli = new Cliente("Merli", "Cat", TipoDocumento.DNI, "50334432", 
					LocalDate.of(2005, 03, 19), carrito2 , true, new ArrayList<OrdenDeCompra>());
			
			Cliente gisele = new Cliente("Gilese", "Martinez", TipoDocumento.DNI, "40334432", 
					LocalDate.of(1995, 01, 19), carrito3 , true, new ArrayList<OrdenDeCompra>());
			
			List<Cliente> clientesIciales = List.of(carolina,merli,gisele);
			
			clientesIciales.stream().forEach(cliente->{
				repoCliente.save(cliente);
			});
			
			
			Proveedor dell = new Proveedor("Dell SA", "Florida 731, C1054 CABA", "30-68412579-2", "0800-555-7267",
					"dell@dell.com");
			Proveedor casio = new Proveedor("Casio", "Av. Corrientes 456 Oficina 64, C1043 CABA", "30-86411111-4",
					"011 5252-3434", "casio@casio.com");
			List<Proveedor> proveedoresIniciales = List.of(dell,casio);
			
			proveedoresIniciales.stream().forEach(proveedor -> {
				repoProveedor.save(proveedor);
			});	
			
			List<Producto> productosIniciales = List.of( 
					new Producto("Notebook Dell", 250000.0, dell, 5,"https://ar-media.hptiendaenlinea.com/catalog/product/cache/b3b166914d87ce343d4dc5ec5117b502/8/v/8vv82la_c.png"), 
					new Producto("Calculadora", 7500.0, casio, 20,"https://cdn.shopify.com/s/files/1/1086/1234/products/FX_20570LA_20PLUS-700x700_1024x1024.jpg?v=1531959894"),  
					new Producto("Reloj", 12500.0, casio, 8,"https://d3ugyf2ht6aenh.cloudfront.net/stores/844/620/products/b-640wd-1a1-05a75d1fe7fa1ba23f15933014233306-1024-1024.jpg"));
			
			productosIniciales.stream().forEach(producto -> {
				repoProducto.save(producto);
			});	
		}
		

	}

}
