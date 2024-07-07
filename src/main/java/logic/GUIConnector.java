package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Interface used for the logic of the game racetrack to
 * communicate with the gui.
 *
 * @author Joshua-Scott Schöttke
 */
public interface GUIConnector {
    /**
     * Sets the text of the Errorcode
     * @param Error The Errorcode
     */
    void setErrorString (ValidTrack Error);

    void setPoints (String points, int currentPlayer);

    void setBackgroundColor (int fieldLength, Position[] allPossibleFields);

    void removeImage (Position pos, ImageView imgView);

    void setImage (Position startPos, Position targetPos, Image img, ImageView droppedImageView);

    /**
     * Called when the game is won by a player. Needs to display the
     * winner on the gui and has to ensure that the user cannot continue playing, by disabling
     * components.
     *
     * @param currentPlayer name of the player than won
     */
    void onGameEnd (int currentPlayer);
}
