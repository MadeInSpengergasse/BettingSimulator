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


    private String teamA;
    private String teamB;
    private int oddsA;
    private int oddsB;

    private StringProperty odds;
    private StringProperty teams;

    public Match(String teamA, String teamB, int oddsA, int oddsB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.oddsA = oddsA;
        this.oddsB = oddsB;

        this.odds = new SimpleStringProperty(oddsA + " : " + oddsB);
        this.teams = new SimpleStringProperty(teamA + " vs " + teamB);
    }

    public Match() {
        this("Furry Foxes", "Blue Muffins", 34, 66);
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getOddsA() {
        return oddsA;
    }

    public int getOddsB() {
        return oddsB;
    }

    public String getOdds() {
        return odds.get();
    }

    public StringProperty oddsProperty() {
        return odds;
    }

    public String getTeams() {
        return teams.get();
    }

    public StringProperty teamsProperty() {
        return teams;
    }
}
