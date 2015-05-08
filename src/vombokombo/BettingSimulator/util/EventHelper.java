package vombokombo.BettingSimulator.util;

import vombokombo.BettingSimulator.model.Event;
import vombokombo.BettingSimulator.model.Event.EventType;

import java.util.Random;

public class EventHelper {

    public static Event generateEvent(String teamNameA, String teamNameB, int timeSeconds) {
        Random random = new Random();

        if (random.nextInt(100) <= 5) {
            if (random.nextInt(2) == 0) {
                return new Event(timeSeconds, (teamNameA + " scored a goal!"), EventType.GOAL_A);
                //TODO: Add randomness! and more events!
            } else {
                return new Event(timeSeconds, (teamNameB + " scored a goal!"), EventType.GOAL_B);
            }
        }
        return null;
    }

}
