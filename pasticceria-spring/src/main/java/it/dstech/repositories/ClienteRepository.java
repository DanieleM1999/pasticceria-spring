package it.dstech.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.dstech.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	List<Cliente> findByName(String nome);

}
