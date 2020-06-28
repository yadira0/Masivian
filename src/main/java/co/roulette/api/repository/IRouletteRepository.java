package co.roulette.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.roulette.api.model.Roulette;

@Repository
public interface IRouletteRepository extends CrudRepository<Roulette, Long> {
	

}
