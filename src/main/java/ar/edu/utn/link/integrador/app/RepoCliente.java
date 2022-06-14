package ar.edu.utn.link.integrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.integrador.app.dtos.ClienteDTO;
import ar.edu.utn.link.integrador.model.Cliente;

@RepositoryRestResource(path="clientes", excerptProjection = ClienteDTO.class)
public interface RepoCliente extends PagingAndSortingRepository<Cliente, Integer>{
	
	Optional<Cliente> findByNombre(String nombre);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Cliente entity);
}
