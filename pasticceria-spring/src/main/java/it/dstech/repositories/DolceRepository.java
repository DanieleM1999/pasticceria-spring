package it.dstech.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.dstech.model.Dolce;

@Repository
public interface DolceRepository extends CrudRepository<Dolce, Long> {

	List<Dolce> findByName(String nome);

}
