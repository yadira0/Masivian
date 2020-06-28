package co.roulette.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.roulette.api.constant.RouletteConstant;
import co.roulette.api.model.Bet;
import co.roulette.api.model.Roulette;
import co.roulette.api.repository.IRouletteRepository;

@Service
public class RouletteService implements IRouletteService {

	@Autowired
	IRouletteRepository rouletteRepository;

	@Autowired
	HttpServletRequest requestHeader;

	@Override
	public Long createRoulette() {
		Roulette createRequestRoulette = new Roulette();
		Roulette responseRoulette = rouletteRepository.save(createRequestRoulette);
		return responseRoulette.getIdRoulette();
	}

	@Override
	public String activateRoulette(long idRoulette) {
		String response = "";
		Optional<Roulette> rouletteAllId = rouletteRepository.findById(idRoulette);
		if (rouletteAllId.isPresent()) {
			Roulette requestActivateRoulette = rouletteAllId.get();
			if (!requestActivateRoulette.isStatus())
				requestActivateRoulette.setBets(null);
			requestActivateRoulette.setStatus(true);
			rouletteRepository.save(requestActivateRoulette);
			response = RouletteConstant.ROULETTE_CODE_RESPONSE_SUCCESSFULL
					+ RouletteConstant.ROULETTE_SUCCESSFUL_MESSAGE;

		} else {
			response = RouletteConstant.ROULETTE_RESPONSE_CODE_FAILED + RouletteConstant.ROULETTE_DENIED_MESSAGE;
		}
		return response;
	}

	@Override
	public String registerBet(Bet bet) {
		boolean statusRoulette = checkRouletteStatus(bet.getIdRoulette());
		String response;
		if (statusRoulette && bet.getBetValue() > 0 && bet.getBetValue() <= 10000) {
			response = saveBet(bet);
		} else {
			response = RouletteConstant.ROULETTE_RESPONSE_CODE_FAILED + RouletteConstant.ROULETTE_DENIED_MESSAGE;
		}
		return response;
	}

	@Override
	public List<Bet> closeRoulette(long idRoulette) {
		Roulette dataRoulette = new Roulette();
		Optional<Roulette> roulette = rouletteRepository.findById(idRoulette);
		if (roulette.isPresent()) {
			dataRoulette = roulette.get();
			if (dataRoulette.isStatus()) {
				return dataRoulette.getBets();
			}
		}
		return new ArrayList<>();
	}

	@Override
	public List<Roulette> getAllRoulettes() {
		List<Roulette> roulettes = new ArrayList<>();
		rouletteRepository.findAll().forEach(roulettes::add);
		return roulettes;
	}

	private String saveBet(Bet request) {
		Roulette roulette = rouletteRepository.findById(request.getIdRoulette()).get();
		request.setIdUser(requestHeader.getHeader("user"));
		if (request.getColor() != null) {
			request.setNumberBet(null);
		} else {
			request.setColor(null);
		}
		roulette.insertBet(request);
		rouletteRepository.save(roulette);
		return RouletteConstant.ROULETTE_CODE_RESPONSE_SUCCESSFULL + RouletteConstant.ROULETTE_SUCCESSFUL_MESSAGE;
	}

	private boolean checkRouletteStatus(Long idRoulette) {
		Optional<Roulette> rouletteActive = rouletteRepository.findById(idRoulette);
		if (rouletteActive.isPresent()) {
			if (rouletteActive.get().isStatus()) {
				return true;
			}
		}
		return false;
	}

}
