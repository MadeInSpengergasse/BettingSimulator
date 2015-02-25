package vombokombo.BettingSimulator.model;

import java.util.ArrayList;

public class Team {
	
	private String name;
	private short wins;
	private short loss;
	private ArrayList<Member> members;

	public Team (String name, short wins, short loss){
		setName(name);
		setWins(wins);
		setLoss(loss);
		members=new ArrayList<Member>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the wins
	 */
	public short getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(short wins) {
		this.wins = wins;
	}

	/**
	 * @return the loss
	 */
	public short getLoss() {
		return loss;
	}

	/**
	 * @param loss the loss to set
	 */
	public void setLoss(short loss) {
		this.loss = loss;
	}
	
	public boolean addMember(Member m){
		if (members.contains(m)){
			return false;
		}
		return members.add(m);
	}
	
	public boolean deleteMember (Member m){
		if (members.contains(m)){
			return members.remove(m);
		}
		return false;
	}
	
	public void showTeam (){
		System.out.println ("Team Information");
		System.out.println ("----------------");
		for (int i=0; i<members.size();i++){
			System.out.println ("Member "+i+": "+members.get(i).toString());
		}
	}
}
