package vombokombo.BettingSimulator.util;

import vombokombo.BettingSimulator.model.Event;
import vombokombo.BettingSimulator.model.Event.EventType;

import java.util.Random;

public class EventHelper {

    /**
     * generates an event based on the following parameters
     *
     * @param teamNameA   the name of team A
     * @param teamNameB   the name of team B
     * @param oddsA       the odds of team A
     * @param timeSeconds the total time in seconds
     * @return an event if "successful", otherwise null
     */
    public static Event generateEvent(String teamNameA, String teamNameB, int oddsA, int timeSeconds) {
        Random random = new Random();
        if (random.nextInt(1000) <= 25) {
            if (oddsA >= random.nextInt(100) || random.nextInt(10) == 0) {
                return new Event(timeSeconds, (teamNameA + " scored a goal!"), EventType.GOAL_A);
                //TODO: Add randomness! and more events!
            } else {
                return new Event(timeSeconds, (teamNameB + " scored a goal!"), EventType.GOAL_B);
            }
        }
        return null;
    }

}
