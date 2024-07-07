package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.GridPane;

import java.util.Objects;

import static logic.Position.getPosFromString;

/**
 * The logic behind the game. This class controls the movement of the player, checking for bounds
 * and connects with gui
 *
 * @author Joshua-Scott Schöttke
 */
public class Game {
    /**
     * logic GameField
     */
    private StoneHolder[][] gameField;
    /**
     * current Player
     */
    private int currentPlayer;
    /**
     * points of Players
     */
    private int[] points;
    /**
     * the field length/width
     */
    private static final int FIELDWIDTHLENGTH = 7;
    /**
     * Connection to the gui.
     */
    private final GUIConnector gui;

    /**
     * Getter/Setter
     */
    public StoneHolder[][] getGameField () {
        return gameField;
    }

    public int getFIELDWIDTHLENGTH () {
        return FIELDWIDTHLENGTH;
    }

    public void setCurrentPlayer (int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int[] getPoints () {
        return points;
    }

    /**
     * Test-Constructor
     *
     * @param testField gamefiled
     * @param points    drive direction
     * @param gui       the connection to the Gui Connector
     */
    public Game (TestStone[][] testField, int[] points, GUIConnector gui) {
        StoneHolder[][] field = new StoneHolder[testField.length][testField[0].length];

        StoneHolder stone;

        for (int x = 0; x < testField.length; x++) {
            for (int y = 0; y < testField[x].length; y++) {
                switch (testField[y][x]) {
                    case H1:
                        stone = new StoneHolder(Stone.HERZMUSCHEL1);
                        break;
                    case H1T:
                        stone = new StoneHolder(Stone.HERZMUSCHEL1);
                        stone.setTower(true);
                        break;
                    case H2:
                        stone = new StoneHolder(Stone.HERZMUSCHEL2);
                        break;
                    case H2T:
                        stone = new StoneHolder(Stone.HERZMUSCHEL2);
                        stone.setTower(true);
                        break;
                    case M1:
                        stone = new StoneHolder(Stone.MOEWE1);
                        break;
                    case M1T:
                        stone = new StoneHolder(Stone.MOEWE1);
                        stone.setTower(true);
                        break;
                    case M2:
                        stone = new StoneHolder(Stone.MOEWE2);
                        break;
                    case M2T:
                        stone = new StoneHolder(Stone.MOEWE2);
                        stone.setTower(true);
                        break;
                    case S1:
                        stone = new StoneHolder(Stone.SEESTERN1);
                        break;
                    case S1T:
                        stone = new StoneHolder(Stone.SEESTERN1);
                        stone.setTower(true);
                        break;
                    case S2:
                        stone = new StoneHolder(Stone.SEESTERN2);
                        break;
                    case S2T:
                        stone = new StoneHolder(Stone.SEESTERN2);
                        stone.setTower(true);
                        break;
                    case R1:
                        stone = new StoneHolder(Stone.ROBBE1);
                        break;
                    case R1T:
                        stone = new StoneHolder(Stone.ROBBE1);
                        stone.setTower(true);
                        break;
                    case R2:
                        stone = new StoneHolder(Stone.ROBBE2);
                        break;
                    case R2T:
                        stone = new StoneHolder(Stone.ROBBE2);
                        stone.setTower(true);
                        break;
                    case M:
                        stone = new StoneHolder(Stone.MEER);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + testField[y][x]);
                }
                field[x][y] = stone;
            }
        }

        this.points = points;

        this.gameField = field;

        this.gui = gui;
    }

    /**
     * Constructor for initialize and loading the game
     *
     * @param var variant of game
     * @param gui UI
     */
    public Game (int var, GUIConnector gui) {
        String[][] dataTrack = new String[][] {};
        int[]      points    = new int[] { 0, 0 };
        GameData   gameData  = new GameData(dataTrack, points);
        gameData = gameData.loadGameData(var);

        this.gameField = new StoneHolder[FIELDWIDTHLENGTH][FIELDWIDTHLENGTH];

        initField(gameData.getField());

        this.points = new int[] { gameData.getPoints()[0], gameData.getPoints()[1] };

        this.gui = gui;
    }

    /**
     * Constructor for loading the game from a save File
     *
     * @param filename name of file
     * @param gui      UI
     */
    public Game (String filename, GUIConnector gui) {
        String[][] dataTrack = new String[][] {};
        int[]      points    = new int[] { 0, 0 };
        GameData   gameData  = new GameData(dataTrack, points);
        gameData = gameData.loadGameData(filename);

        this.gameField = new StoneHolder[FIELDWIDTHLENGTH][FIELDWIDTHLENGTH];

        initField(gameData.getField());

        this.points = new int[] { gameData.getPoints()[0], gameData.getPoints()[1] };

        this.gui = gui;
    }

    /**
     * initialize the Game from a json data
     *
     * @param gameField the string representation of the field
     */
    private void initField (String[][] gameField) {
        StoneHolder[] stones = new StoneHolder[getFIELDWIDTHLENGTH() * getFIELDWIDTHLENGTH()];
        int           k      = 0;
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                switch (gameField[y][x]) {
                    case "1H" -> stones[k] = new StoneHolder(Stone.HERZMUSCHEL1);
                    case "1H^" -> {
                        stones[k] = new StoneHolder(Stone.HERZMUSCHEL1);
                        stones[k].setTower(true);
                    }
                    case "2H" -> stones[k] = new StoneHolder(Stone.HERZMUSCHEL2);
                    case "2H^" -> {
                        stones[k] = new StoneHolder(Stone.HERZMUSCHEL2);
                        stones[k].setTower(true);
                    }
                    case "1M" -> stones[k] = new StoneHolder(Stone.MOEWE1);
                    case "1M^" -> {
                        stones[k] = new StoneHolder(Stone.MOEWE1);
                        stones[k].setTower(true);
                    }
                    case "2M" -> stones[k] = new StoneHolder(Stone.MOEWE2);
                    case "2M^" -> {
                        stones[k] = new StoneHolder(Stone.MOEWE2);
                        stones[k].setTower(true);
                    }
                    case "1S" -> stones[k] = new StoneHolder(Stone.SEESTERN1);
                    case "1S^" -> {
                        stones[k] = new StoneHolder(Stone.SEESTERN1);
                        stones[k].setTower(true);
                    }
                    case "2S" -> stones[k] = new StoneHolder(Stone.SEESTERN2);
                    case "2S^" -> {
                        stones[k] = new StoneHolder(Stone.SEESTERN2);
                        stones[k].setTower(true);
                    }
                    case "1R" -> stones[k] = new StoneHolder(Stone.ROBBE1);
                    case "1R^" -> {
                        stones[k] = new StoneHolder(Stone.ROBBE1);
                        stones[k].setTower(true);
                    }
                    case "2R" -> stones[k] = new StoneHolder(Stone.ROBBE2);
                    case "2R^" -> {
                        stones[k] = new StoneHolder(Stone.ROBBE2);
                        stones[k].setTower(true);
                    }
                    case "~~" -> stones[k] = new StoneHolder(Stone.MEER);
                    default ->
                            throw new IllegalStateException("Unexpected value: " + gameField[y][x]);
                }
                this.gameField[x][y] = stones[k];
                k++;
            }
        }
    }

    /**
     * save the game data to a json
     *
     * @param filename the name under saving
     */
    public void saveGame (String filename) {
        String[][] dataTrack  = new String[][] {};
        int[]      dataPoints = new int[] { points[0], points[1] };
        GameData   gameData   = new GameData(dataTrack, dataPoints);
        gameData.saveGameData(this.gameField, dataPoints, filename);
    }

    /**
     * load the game data from a json
     *
     * @param filename the name under saving
     */
    public void loadGame (String filename) {
        String[][] dataTrack = new String[][] {};
        int[]      points    = new int[] { 0, 0 };
        GameData   gameData  = new GameData(dataTrack, points);
        gameData = gameData.loadGameData(filename);

        this.gameField = new StoneHolder[FIELDWIDTHLENGTH][FIELDWIDTHLENGTH];

        initField(gameData.getField());

        this.points = new int[] { gameData.getPoints()[0], gameData.getPoints()[1] };
    }

    /**
     * Handles the turn of a player. It identified the player as a human or an AI and orders the
     * relevant turn handel. Then the current player is changed, so that it is the turn of the next
     * player. Finally, the method checks if through this turn a player has won the game.
     *
     * @param oldPos the old coord of the stone
     * @param newPos the new coord in the field at which the player wants to place his/her symbol
     */
    public void turn (Position oldPos, Position newPos) {
        if (currentPlayer == 0) {
            playerTurn(oldPos, newPos);
        }

        if (currentPlayer == 1) {
            aiTurn();
        }
        handelEndOfGame();
    }

    /**
     * rules the human turn.
     *
     * @param oldPos the old pos of the stone
     * @param newPos the new pos of the stone
     */

    private void playerTurn (Position oldPos, Position newPos) {
        if (isPosValid(newPos)) {
            StoneHolder stone = gameField[oldPos.x()][oldPos.y()];
            if (possibleField(stone, newPos)) {
                if (possiblePoint(stone, newPos)) {

                    playerGetPoint(newPos);
                } else if (isPosOpponent(newPos)) {
                    gameField[newPos.x()][newPos.y()] = stone;
                    gameField[newPos.x()][newPos.y()].setTower(true);
                } else {
                    gameField[newPos.x()][newPos.y()] = stone;
                }
                gameField[oldPos.x()][oldPos.y()] = new StoneHolder(Stone.MEER);
                currentPlayer                     = (currentPlayer + 1) % 2;
            }
        }
    }

    /**
     * regulates the awarding of points and sets the playing field
     *
     * @param newPos the target position
     */
    private void playerGetPoint (Position newPos) {
        gameField[newPos.x()][newPos.y()] = new StoneHolder(Stone.MEER);
        points[currentPlayer]++;
        String point = String.valueOf(points[currentPlayer]);
        gui.setPoints(point, currentPlayer);

    }

    /**
     * rules the ai turn
     */
    private void aiTurn () {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    /**
     * creates a Position[] of all possible moves
     *
     * @param pos of the chosen stone
     *
     * @return all possible moves
     */
    public Position[] allMoves (Position pos) {
        StoneHolder stone = gameField[pos.x()][pos.y()];
        Position[]  all   = new Position[stone.getStone().getMove().length];
        int         count = 0;
        int         idx   = 0;

        for (int i = 0; i < stone.getStone().getMove().length; i++) {
            int      x        = pos.x() + stone.getStone().getMove()[i].getMove().x();
            int      y        = pos.y() + stone.getStone().getMove()[i].getMove().y();
            Position possible = new Position(x, y);
            if (possibleField(stone, possible)) {
                all[i] = possible;
                count++;
            }
        }
        Position[] allPossibles = new Position[count];

        //Copies the array without null-elements
        for (Position position : all) {
            if (position != null) {
                allPossibles[idx] = position;
                idx++;
            }
        }
        return allPossibles;
    }

    /**
     * tests whether the player can occupy the position on the field
     *
     * @param stone the stone that would be moved
     * @param pos   the target position
     *
     * @return return true if the player can occupy the position, false if not
     */
    public boolean possibleField (StoneHolder stone, Position pos) {
        boolean possible = isPosValid(pos);

        if (possible && !Objects.equals(gameField[pos.x()][pos.y()], new StoneHolder(Stone.MEER))) {
            StoneHolder opponent = gameField[pos.x()][pos.y()];
            if (isStoneOwn(pos)) {
                possible = false;
            } else if (opponent.getTower() && stone.getTower()) {
                possible = false;
            }
        }
        return possible;
    }

    /**
     * determines whether the next move brings a victory point
     *
     * @param stone of the current player
     * @param pos   of the target position
     *
     * @return true if the next move brings a victory point, false if not
     */
    public boolean possiblePoint (StoneHolder stone, Position pos) {
        boolean possible = false;
        //Player 0 doesen't exist. It's water
        if (stone.getStone().getPlayer() == 1 && isPosEdge(pos)) {
            possible = true;
        } else if (stone.getStone().getPlayer() == 2 && isPosEdge(pos)) {
            possible = true;
        }
        if (!possible && isPosOpponent(pos) && stone.getTower()
                || gameField[pos.x()][pos.y()].getTower()) {
            possible = true;
        }
        return possible;
    }

    /**
     * tests the coordinated on the gamefield
     *
     * @param pos coordinate in the gamefield
     *
     * @return true if valid
     */
    public boolean isPosValid (Position pos) {
        return (pos.x() >= 0 && pos.x() < FIELDWIDTHLENGTH) && (pos.y() >= 0
                && pos.y() < FIELDWIDTHLENGTH);
    }

    /**
     * tests whether the position is occupied by the opponent
     *
     * @param pos coordinate in the gamefield where the player wants to place the stone
     *
     * @return true if there is a opponents stone
     */
    public boolean isPosOpponent (Position pos) {
        boolean opponent = false;
        if (currentPlayer == 0 && gameField[pos.x()][pos.y()].getStone().getPlayer() == 2) {
            opponent = true;
        } else if (currentPlayer == 1 && gameField[pos.x()][pos.y()].getStone().getPlayer() == 1) {
            opponent = true;
        }
        return opponent;
    }

    /**
     * tests the position, whether it is on the edge of the opponent
     *
     * @param pos coordinate in the gamefield where the player wants to place the stone
     *
     * @return true if there is the edge of the opponent
     */
    public boolean isPosEdge (Position pos) {
        boolean edge = false;
        if (currentPlayer == 0 && pos.y() == 0) {
            edge = true;
        } else if (currentPlayer == 1 && pos.y() == FIELDWIDTHLENGTH - 1) {
            edge = true;
        }
        return edge;
    }

    /**
     * tests whether the stone belongs to the player
     *
     * @param pos position of the chosen stone
     *
     * @return true when the player choose one of them stones. False if not.
     */
    public boolean isStoneOwn (Position pos) {
        boolean correct = false;
        if (currentPlayer == 0 && gameField[pos.x()][pos.y()].getStone().getPlayer() == 1) {
            correct = true;
        } else if (currentPlayer == 1 && gameField[pos.x()][pos.y()].getStone().getPlayer() == 2) {
            correct = true;
        }
        return correct;
    }

    /**
     * handle the end of game
     */
    private void handelEndOfGame () {
        if (points[0] >= 3 || points[1] >= 3) {
            gui.onGameEnd(currentPlayer);
        }
    }

    public void handleDragStart (GridPane grdPn, ImageView imgView, Position start) {
        Position[] allPossibleFields = allMoves(start);
        gui.setBackgroundColor(FIELDWIDTHLENGTH, allPossibleFields);
    }

    public ImageView handleDragDrop (Dragboard db, GridPane grdPn, DragEvent event) {
        boolean   possible = false;
        boolean   attacks  = false;
        ImageView droppedImageView = new ImageView(db.getImage());
        Image img = droppedImageView.getImage();

        String   pos      = db.getString();
        Position startPos = getPosFromString(pos);

        Position[] allPossibleFields = allMoves(startPos);

        Position departurePos = new Position(
                (int) (event.getX() / (grdPn.getWidth() / grdPn.getColumnCount())),
                (int) (event.getY() / (grdPn.getHeight() / grdPn.getRowCount())));

        for (int i = 0; i < allPossibleFields.length && !possible; i++) {
            if (departurePos.equals(allPossibleFields[i])) {
                possible = true;
                if (isPosOpponent(departurePos)) {
                    attacks = true;
                }
            }
        }


        if (possible) {
            //gui.removeImage(startPos, null);
            gui.setImage(startPos, departurePos, img, droppedImageView);
            turn(startPos, departurePos);
        }
        return droppedImageView;
    }
}
