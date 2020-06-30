package it.dstech.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.dstech.model.Ricetta;

@Repository
public interface RicettaRepository extends CrudRepository<Ricetta, Long> {

	List<Ricetta> findByName(String nome);

}
