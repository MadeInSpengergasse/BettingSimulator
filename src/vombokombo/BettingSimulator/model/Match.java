package vombokombo.BettingSimulator.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vombokombo.BettingSimulator.util.TimeStamp;

/**
 * Created by luca on 06.05.15.
 */
public class Match {


    private StringProperty teamA;
    private StringProperty teamB;
    private IntegerProperty oddsA;
    private IntegerProperty oddsB;

    public Match(String teamA, String teamB, int oddsA, int oddsB) {
        this.teamA = new SimpleStringProperty(teamA);
        this.teamB = new SimpleStringProperty(teamB);
        this.oddsA = new SimpleIntegerProperty(oddsA);
        this.oddsB = new SimpleIntegerProperty(oddsB);
    }

    public Match() {
        this("Furry Foxes", "Blue Muffins", 34, 66);
    }


    public String getTeamB() {
        return teamB.get();
    }

    public StringProperty teamBProperty() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB.set(teamB);
    }

    public String getTeamA() {
        return teamA.get();
    }

    public StringProperty teamAProperty() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA.set(teamA);
    }

    public int getOddsA() {
        return oddsA.get();
    }

    public IntegerProperty oddsAProperty() {
        return oddsA;
    }

    public void setOddsA(int oddsA) {
        this.oddsA.set(oddsA);
    }
}
