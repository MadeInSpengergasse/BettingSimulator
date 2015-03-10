package vombokombo.BettingSimulator.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="save")
public class Save {

	private int money;
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
}
