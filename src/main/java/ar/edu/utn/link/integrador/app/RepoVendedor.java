package ar.edu.utn.link.integrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.integrador.app.dtos.ProveedorDTO;
import ar.edu.utn.link.integrador.app.dtos.VendedorDTO;
import ar.edu.utn.link.integrador.model.Proveedor;
import ar.edu.utn.link.integrador.model.Vendedor;


@RepositoryRestResource(path="vendedores", excerptProjection = VendedorDTO.class)
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer>{
	
	Optional<Vendedor> findByNombre(String nombre);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Vendedor entity);
}
