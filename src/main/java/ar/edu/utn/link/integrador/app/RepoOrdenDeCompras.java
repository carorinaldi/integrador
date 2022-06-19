package ar.edu.utn.link.integrador.app;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.integrador.app.dtos.ClienteDTO;
import ar.edu.utn.link.integrador.app.dtos.OrdenDeCompraDTO;
import ar.edu.utn.link.integrador.model.Cliente;
import ar.edu.utn.link.integrador.model.OrdenDeCompra;

@RepositoryRestResource(path="ordenes", excerptProjection = OrdenDeCompraDTO.class)
public interface RepoOrdenDeCompras extends PagingAndSortingRepository<OrdenDeCompra, Integer>{
	
	Optional<OrdenDeCompra> findByFecha(LocalDate fecha);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(OrdenDeCompra entity);
}
