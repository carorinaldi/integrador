package ar.edu.utn.link.integrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.integrador.app.dtos.ProveedorDTO;
import ar.edu.utn.link.integrador.model.Proveedor;


@RepositoryRestResource(path="proveedores", excerptProjection = ProveedorDTO.class)
public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer>{
	
	Optional<Proveedor> findByRazonSocial(String razonSocial);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Proveedor entity);
}
