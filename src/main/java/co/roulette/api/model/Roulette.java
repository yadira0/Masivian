package co.roulette.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Roulette")
public class Roulette {

	@Id
	private Long idRoulette;
	private boolean status;
	private List<Bet> bets;
	
	public Roulette() {
		bets = new ArrayList<>();
	}
	
	public Roulette(Long idRoulette, boolean status) {
		this.idRoulette= idRoulette;
		this.status=status;
	}

	public long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(long idRoulette) {
		this.idRoulette = idRoulette;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
	
	public void insertBet(Bet bet) {
		this.bets.add(bet);
	}
	
}
