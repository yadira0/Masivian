package co.roulette.api.service;

import java.util.List;

import co.roulette.api.model.Bet;
import co.roulette.api.model.Roulette;

public interface IRouletteService {
	
	public Long createRoulette() ;

	public List<Roulette> getAllRoulettes();
	
	public String activateRoulette(long idRoulette);
	
	public String registerBet(Bet bet);
	
	public List<Bet> closeRoulette(long idRoulette);
	
}
