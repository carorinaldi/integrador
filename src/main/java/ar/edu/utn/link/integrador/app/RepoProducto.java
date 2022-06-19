package ar.edu.utn.link.integrador.app;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ar.edu.utn.link.integrador.app.dtos.ProductoDTO;
import ar.edu.utn.link.integrador.model.Producto;

@RepositoryRestResource(path="productos", excerptProjection = ProductoDTO.class)
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer>{
	
	Optional<Producto> findByNombre(String nombre);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Producto entity);
}
