package vombokombo.BettingSimulator.model;

import java.util.Random;

import vombokombo.BettingSimulator.model.Event.EventType;

public class Events {

    public static Event generateEvent(String teamNameA, String teamNameB, int timeSeconds) {
        Random random = new Random();

        if (random.nextInt(100) <= 5) {
            if (random.nextInt(2) == 0) {
                return new Event(timeSeconds, (teamNameA + " scored a goal!"), EventType.GOAL);
            }
        }
        return null;
    }

}
