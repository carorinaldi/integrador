package ar.edu.utn.link.integrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.integrador.app.dtos.CarritoDTO;
import ar.edu.utn.link.integrador.model.Carrito;
import ar.edu.utn.link.integrador.model.Cliente;


@RepositoryRestResource(path="carritos", excerptProjection = CarritoDTO.class)
public interface RepoCarrito extends PagingAndSortingRepository<Carrito, Integer>{
	
	Optional<Carrito> findById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Carrito entity);
}
