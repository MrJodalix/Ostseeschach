package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Fake GUI used for testing the logic of the game Tic Tac Toe. All methods do nothing. To ensure
 * that the logic calls the correct methods for the gui, it could be possibly to add package private
 * boolean attributes, that tell if a certain method has been called.
 *
 * @author cei
 */
public class FakeGUI implements GUIConnector {

    @Override public void setErrorString (ValidTrack Error) {
    }

    @Override public void setPoints (String points, int currentPlayer) {

    }

    @Override public void setBackgroundColor (int fieldLength, Position[] allPossibleFields) {

    }

    @Override public void removeImage (Position pos, ImageView imgView) {

    }

    @Override public void setImage (Position startPos, Position targetPos, Image img,
            ImageView droppedImageView) {

    }

    @Override public void onGameEnd (int currentPlayer) {

    }
}
