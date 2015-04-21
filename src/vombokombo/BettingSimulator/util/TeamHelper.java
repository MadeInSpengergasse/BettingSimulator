package vombokombo.BettingSimulator.util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Created by Luca on 21.04.2015.
 */
public class TeamHelper {

    public static int lineCount = -1;
    public static final String FILENAME = "teamnames.txt";

    public static String getRandomTeamName() {
        try {
            if (lineCount == -1) {
                BufferedReader reader = new BufferedReader(new FileReader(new File(TeamHelper.class.getResource(FILENAME).toURI())));
                int tempCount = 0;
                String read = reader.readLine();
                while (read != null) {
                    tempCount++;
                    reader.readLine();
                }
                lineCount = tempCount;

            }
            BufferedReader reader = new BufferedReader(new FileReader(new File(TeamHelper.class.getResource(FILENAME).toURI())));
            int pos = new Random().nextInt(lineCount);

            for (int i = 0; i < pos; i++) {
                reader.readLine();
            }
            return reader.readLine();
        } catch(Exception e){

            return "ERROR";
        }
    }

}
