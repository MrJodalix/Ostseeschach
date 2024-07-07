package logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.stage.FileChooser;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;

/**
 * This class loads and saves the game-files in a json format
 *
 * @author Joshua-Scott Schöttke
 */
public class GameData {

    /**
     * Field for play
     */
    private final String[][] field;

    /**
     * Points for the players
     */
    private final int[] points;

    /**
     * Constructor
     *
     * @param field  the field datas
     * @param points the players
     */
    public GameData (String[][] field, int[] points) {
        this.field  = field;
        this.points = points;
    }

    /**
     * Getter
     **/
    public String[][] getField () {
        return field;
    }

    public int[] getPoints () {
        return points;
    }

    /**
     * search for the target/classes folder
     * @return the direction to the folder
     */
    private File findFile(){
        File currDir = null;
        try {
            currDir = new File(
                    this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException ex) {
            //oops... ¯\_(ツ)_/¯
            //guess we won't be opening the dialog in the right directory
        }
        return currDir;
    }

    /**
     * gets the gameData of a save game.
     * @param path path to the File
     * @param gson
     * @return
     */
    private GameData readGameData(String path, Gson gson){
        GameData gameData;
        try (Reader reader = new FileReader(path)) {

            gameData = gson.fromJson(reader, GameData.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gameData;
    }

    /**
     * loads the Data of an json data
     *
     * @param var the name of the file in the saves folder
     *
     * @return the basic data of the game
     */
    protected GameData loadGameData (int var) {
        Gson gson = new Gson();

        File currDir = findFile();
        //Step 2: Put it together
        FileChooser fileChooser = new FileChooser();

        if (currDir != null) {
            //ensure the dialog opens in the correct directory
            fileChooser.setInitialDirectory(currDir.getParentFile().getParentFile());
            switch (var) {
                case 0 -> fileChooser.setInitialDirectory(new File(
                        fileChooser.getInitialDirectory() + "/src/main/resources/json/Var0.json"));
                case 1 -> fileChooser.setInitialDirectory(new File(
                        fileChooser.getInitialDirectory() + "/src/main/resources/json/Var1.json"));
                case 2 -> fileChooser.setInitialDirectory(new File(
                        fileChooser.getInitialDirectory() + "/src/main/resources/json/Var2.json"));
                case 3 -> fileChooser.setInitialDirectory(new File(
                        fileChooser.getInitialDirectory() + "/src/main/resources/json/Var3.json"));
                case 4 -> fileChooser.setInitialDirectory(new File(
                        fileChooser.getInitialDirectory() + "/src/main/resources/json/Var4.json"));
                case 5 -> fileChooser.setInitialDirectory(new File(
                        fileChooser.getInitialDirectory() + "/src/main/resources/json/Var5.json"));
            }
        }

        String path = fileChooser.getInitialDirectory().getPath();

        GameData gameData = readGameData(path, gson);

        return gameData;
    }

    /**
     * loads the Data of an json data
     *
     * @param filename the name of the file in the saves folder
     *
     * @return the basic data of the game
     */
    protected GameData loadGameData (String filename) {
        Gson gson = new Gson();

        File currDir = findFile();
        //Step 2: Put it together
        FileChooser fileChooser = new FileChooser();

        if (currDir != null) {
            //ensure the dialog opens in the correct directory
            fileChooser.setInitialDirectory(currDir.getParentFile().getParentFile());
            fileChooser.setInitialDirectory(
                    new File(fileChooser.getInitialDirectory() + "/saves/" + filename));
        }

        String path = fileChooser.getInitialDirectory().getPath();

        GameData gameData = readGameData(path, gson);

        return gameData;
    }

    /**
     * saves the current game in basic data in a format of json
     *
     * @param gameField the current GameField
     * @param points    the current direction
     * @param filename  the filename for saving
     */
    public void saveGameData (StoneHolder[][] gameField, int[] points, String filename) {
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

        File currDir = findFile();

        FileChooser fileChooser = new FileChooser();
        if (currDir != null) {
            //ensure the dialog opens in the correct directory
            fileChooser.setInitialDirectory(currDir.getParentFile().getParentFile());
            fileChooser.setInitialDirectory(
                    new File(fileChooser.getInitialDirectory() + "/saves/" + filename));
        }

        String directionFile = fileChooser.getInitialDirectory().getPath();

        String playStone = "";

        String[][] track = new String[gameField.length][gameField[0].length];

        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                StoneHolder stone = gameField[y][x];
                switch (stone.getStone()) {
                    case HERZMUSCHEL1 -> playStone = stone.getTower() ? "1H^" : "1H";
                    case HERZMUSCHEL2 -> playStone = stone.getTower() ? "2H^" : "2H";
                    case MOEWE1 -> playStone = stone.getTower() ? "1M^" : "1M";
                    case MOEWE2 -> playStone = stone.getTower() ? "2M^" : "2M";
                    case SEESTERN1 -> playStone = stone.getTower() ? "1S^" : "1S";
                    case SEESTERN2 -> playStone = stone.getTower() ? "2S^" : "2S";
                    case ROBBE1 -> playStone = stone.getTower() ? "1R^" : "1R";
                    case ROBBE2 -> playStone = stone.getTower() ? "2R^" : "2R";
                    default -> playStone = "~~";
                }
                track[x][y] = playStone;
            }
        }

        try (FileWriter writer = new FileWriter(directionFile)) {

            GameData gameData = new GameData(track, points);
            gsonPretty.toJson(gameData, writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
