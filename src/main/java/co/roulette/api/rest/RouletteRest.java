package co.roulette.api.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.roulette.api.constant.RouletteConstant;
import co.roulette.api.model.Bet;
import co.roulette.api.model.Roulette;
import co.roulette.api.service.IRouletteService;

@RestController
public class RouletteRest {
	
	@Autowired
	IRouletteService rouletteService;
	
	@PostMapping(RouletteConstant.ROULETTE_REST_CONTROLLER_NEW_ROULETTE)
	public Long createRoulette() {
		return rouletteService.createRoulette();
	}
	
	@PostMapping(RouletteConstant.ROULETTE_REST_CONTROLLER_REGISTER_BET)
	public String registerBet(@RequestBody Bet bet) {
		String registerBet="";
		boolean betValid=validateBet(bet);
		if(betValid) {
			registerBet= rouletteService.registerBet(bet);
		}
		else {
			registerBet= RouletteConstant.ROULETTE_RESPONSE_CODE_FAILED + RouletteConstant.ROULETTE_VALIDATION_MESSAGE;
		}
		return registerBet;		
	}
	
	@GetMapping(RouletteConstant.ROULETTE_REST_CONTROLLER_GET_ALL_ROULETTES)
	public List<Roulette> getAllRoulettes(){
		
		return rouletteService.getAllRoulettes();
	}
	
	
	@GetMapping(RouletteConstant.ROULETTE_REST_CONTROLLER_OPEN_ROULETTE)
	public String activateRoulette(@RequestParam("idRoulette") Long idRoulette ) {
		
		return rouletteService.activateRoulette(idRoulette);
	}
	
	@PutMapping(RouletteConstant.ROULETTE_REST_CONTROLLER_CLOSE_ROULETTE)
	public List<Bet> closeRoulette(@RequestParam("idRoulette") Long idRoulette){
		return rouletteService.closeRoulette(idRoulette);
	}
	
	private boolean validateBet(Bet bet) {
		if(bet.getNumberBet()!=null) {
			if(bet.getNumberBet()>=0 && bet.getNumberBet()<=36) {
				return true;
			}
		}
		else if(bet.getColor()!=null){
			if(bet.getColor().equals("negro") || bet.getColor().equals("rojo")) {
				return true;
			}
		}
		return false;		
	}	
}
