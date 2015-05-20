package vombokombo.BettingSimulator.util;

import vombokombo.BettingSimulator.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Luca on 21.04.2015.
 */
public class TeamHelper {

    private static ArrayList<String> teamnames;

    public static final String FILENAME = "/teamnames.txt";

    public static String getRandomTeamName() {
        try {
            if (teamnames == null) {
                load();
            }
            return teamnames.get(new Random().nextInt(teamnames.size()));
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionDialog.showExceptionDialog(e);
            return "ERROR!";
        }
    }

    private static void load() throws IOException {
        teamnames = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(MainApp.class.getResourceAsStream(FILENAME)));
        String str;
        while ((str = reader.readLine()) != null) {
            teamnames.add(str);
        }
    }

}
