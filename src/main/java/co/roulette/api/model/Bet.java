package co.roulette.api.model;

public class Bet {
	
	private long idBet;
	private String idUser;
	private long idRoulette;
	private String color;
	private Long numberBet;
	private long betValue;
	
	
	public long getIdBet() {
		return idBet;
	}
	public void setIdBet(long idBet) {
		this.idBet = idBet;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}	
	public long getIdRoulette() {
		return idRoulette;
	}
	public void setIdRoulette(long idRoulette) {
		this.idRoulette = idRoulette;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Long getNumberBet() {
		return numberBet;
	}
	public void setNumberBet(Long numberBet) {
		this.numberBet = numberBet;
	}
	public long getBetValue() {
		return betValue;
	}
	public void setBetValue(long betValue) {
		this.betValue = betValue;
	}	

}
