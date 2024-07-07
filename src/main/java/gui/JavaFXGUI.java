package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GUIConnector;
import logic.Position;
import logic.Stone;
import logic.ValidTrack;

public class JavaFXGUI implements GUIConnector {
    /**
     * Images used to represent the symbols of the player.
     */
    private final ImageView[][] imgsField;
    private final Label lblWinnerYou;
    private final Label lblWinnerAi;
    private final Label pointsYou;
    private final Label pointsAi;
    private final GridPane grdPn;

    /**
     * The constructor. Gets passed all components of the gui that may change due to actions in the
     * logic.
     *
     * @param imgs         the Image array, for realisation the field
     * @param lblWinnerYou the Label of the current Player
     * @param lblWinnerAi  the label for naming the winner
     * @param pointsYou    the label for displaying if the track is valid or not.
     * @param pointsAi     the image of the current player
     * @param grdPn        the GridPane for anchor the imageView on the Game field
     */
    public JavaFXGUI (ImageView[][] imgs, Label lblWinnerYou, Label lblWinnerAi, Label pointsYou,
            Label pointsAi, GridPane grdPn) {
        this.imgsField    = imgs;
        this.lblWinnerYou = lblWinnerYou;
        this.lblWinnerAi  = lblWinnerAi;
        this.pointsYou    = pointsYou;
        this.pointsAi     = pointsAi;
        this.grdPn        = grdPn;
    }

    @Override public void setErrorString (ValidTrack Error) {
        //lblTrackValid.setText(Error.getStatus());
    }

    @Override public void setPoints (String points, int currentPlayer){
        if (currentPlayer == 0) {
            pointsYou.setText(points);
        } else {
            pointsAi.setText(points);
        }

    }

    @Override public void setBackgroundColor (int fieldLength, Position[] allPossibleFields) {
        for (Position allPossibleField : allPossibleFields) {
            Pane pane = (Pane) grdPn.getChildren()
                    .get(allPossibleField.x() * fieldLength + allPossibleField.y());

            pane.setBackground(new Background(
                    new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    @Override public void removeImage (Position pos, ImageView imgView) {

    }
    @Override public void setImage (Position startPos, Position targetPos, Image img,
            ImageView droppedImageView) {
        imgsField[startPos.x()][startPos.y()] = new ImageView();
        imgsField[targetPos.x()][targetPos.y()] = new ImageView();
        imgsField[targetPos.x()][targetPos.y()].setImage(img);
         if (img != null) {
             grdPn.add(droppedImageView, targetPos.x(), targetPos.y());
         }
    }

    @Override public void onGameEnd (int currentPlayer) {
        grdPn.setDisable(true);
        if (currentPlayer == 0){
            lblWinnerYou.setText("Win");
            lblWinnerAi.setText("Lose");
        } else {
            lblWinnerYou.setText("Lose");
            lblWinnerAi.setText("Win");
        }
        lblWinnerYou.setVisible(true);
        lblWinnerAi.setVisible(true);
    }
}

