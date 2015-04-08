package vombokombo.BettingSimulator.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="save")
public class Save {

	private float money;
	private int matchesWon;
	private int matchesLost;
	
	
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getMatchesWon() {
		return matchesWon;
	}
	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}
	public int getMatchesLost() {
		return matchesLost;
	}
	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}
	

	
}
