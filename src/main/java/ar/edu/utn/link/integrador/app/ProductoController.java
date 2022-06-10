package ar.edu.utn.link.integrador.app;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.integrador.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private RepoProductoMem repo;
	
	@GetMapping("")
	public Collection<Producto> list(@RequestParam(value="precio", required=false) Integer precio) {
		System.out.println(precio);
		if(precio == null) {
			return repo.all();
		} else {
		return repo.findByPrice(precio);
		}
	}

	
	@GetMapping("/{nombre}")
	public Producto get(@PathVariable("nombre") String nombreProducto) {
		return repo.findByName(nombreProducto);
	}
	
	@PostMapping("")
	public void post(@RequestBody Producto producto) throws ProductoRepetidoException {
		repo.save(producto);
	}
}
