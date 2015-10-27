package vombokombo.BettingSimulator.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by luca on 06.05.15.
 */
public class Match {


    private final String teamA;
    private final String teamB;
    private final int oddsA;
    private final int oddsB;

    private final StringProperty odds;
    private final StringProperty teams;

    /**
     * Constructor
     *
     * @param teamA teamA
     * @param teamB teamB
     * @param oddsA oddsA
     * @param oddsB oddsB
     */
    public Match(String teamA, String teamB, int oddsA, int oddsB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.oddsA = oddsA;
        this.oddsB = oddsB;

        this.odds = new SimpleStringProperty(oddsA + " : " + oddsB);
        this.teams = new SimpleStringProperty(teamA + " vs " + teamB);
    }

    /**
     * Default Constructor
     */
    public Match() {
        this("Furry Foxes", "Blue Muffins", 34, 66);
    }

    /**
     * Get-method for teamA
     *
     * @return teamA
     */
    public String getTeamA() {
        return teamA;
    }

    /**
     * Get-method for teamB
     *
     * @return teamB
     */
    public String getTeamB() {
        return teamB;
    }

    /**
     * Get-method for oddsA
     *
     * @return oddsA
     */
    public int getOddsA() {
        return oddsA;
    }

    /**
     * Get-method for oddsB
     *
     * @return oddsB
     */
    public int getOddsB() {
        return oddsB;
    }

    /**
     * Get-method for odds
     *
     * @return odds.get
     */
    public String getOdds() {
        return odds.get();
    }

    /**
     * Get-method for the odds property
     *
     * @return odds
     */
    public StringProperty oddsProperty() {
        return odds;
    }

    /**
     * Get-method for teams
     *
     * @return teams.get
     */
    public String getTeams() {
        return teams.get();
    }

    /**
     * Get-method for tea
     *
     * @return the property of teams
     */
    public StringProperty teamsProperty() {
        return teams;
    }
}
