package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javafx.stage.Stage;
import logic.Game;
import logic.Position;
import logic.StoneHolder;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import static logic.Position.getPosFromString;

/**
 * Main class for the user interface.
 *
 * @author mjo, cei
 */
public class UserInterfaceController implements Initializable {

    /**
     * gridPane is to be kept square
     */
    @FXML private GridPane grdPn;

    /**
     * wraps the gridPane. Background is yellow with a small border
     */
    @FXML private VBox vBoxWrappingGrdPn;

    /**
     * wraps the VBox, fills the center of the borderpane. Background is red
     */
    @FXML private HBox hBoxWrappingVBox;

    /**
     * Menu Items
     */
    @FXML private MenuItem miNG;
    @FXML private MenuItem miLG;
    @FXML private MenuItem miSG;
    @FXML private MenuItem miCG;
    @FXML private MenuItem miHB;

    @FXML private MenuItem miVar1;
    @FXML private MenuItem miVar2;
    @FXML private MenuItem miVar3;
    @FXML private MenuItem miVar4;
    @FXML private MenuItem miVar5;

    @FXML private Label lblWinnerYou;
    @FXML private Label lblWinnerAi;
    @FXML private Label lblPointsYou;
    @FXML private Label lblPointsAi;

    /**
     * Attribut vom Spielfeld zur Initialisierung des Feldes
     */
    private ImageView[][] field;
    private Game game;

    /**
     * This is where you need to add code that should happen during initialization and then change
     * the java doc comment.
     *
     * @param url            probably not used
     * @param resourceBundle probably not used
     */
    @Override public void initialize (URL url, ResourceBundle resourceBundle) {
        //grdPn width and height both are bound to width of wrapping box
        grdPn.prefWidthProperty().bind(vBoxWrappingGrdPn.widthProperty());
        grdPn.prefHeightProperty().bind(vBoxWrappingGrdPn.heightProperty());

        //bind the width of the vBox to the height of the wrapping hBox
        vBoxWrappingGrdPn.prefWidthProperty().bind(hBoxWrappingVBox.heightProperty());
        vBoxWrappingGrdPn.prefHeightProperty().bind(hBoxWrappingVBox.widthProperty());

        field = new ImageView[][]{};
        game = new Game(0, new JavaFXGUI(field, lblWinnerYou, lblWinnerAi, lblPointsYou,
                lblPointsAi, grdPn));
        resetGridPane(game.getFIELDWIDTHLENGTH(), game.getFIELDWIDTHLENGTH());
        field = initImages(grdPn, game.getGameField());

        grdPn.setDisable(true);
        lblWinnerYou.setVisible(false);
        lblWinnerAi.setVisible(false);
    }

    /**
     * resets the gridpane
     *
     * @param columnLength the length of the field
     * @param rowLength    the width of the field
     */
    private void resetGridPane (int columnLength, int rowLength) {
        grdPn.getChildren().clear();
        grdPn.getColumnConstraints().clear();
        grdPn.getRowConstraints().clear();

        for (int i = grdPn.getColumnCount(); i < columnLength; i++) {
            ColumnConstraints newColConstrains = new ColumnConstraints();
            newColConstrains.setMinWidth(10.0);
            grdPn.getColumnConstraints().add(newColConstrains);
        }
        for (int j = grdPn.getRowCount(); j < rowLength; j++) {
            RowConstraints newRowConstrains = new RowConstraints();
            newRowConstrains.setMinHeight(10.0);
            grdPn.getRowConstraints().add(newRowConstrains);
        }

        int    k  = 0;
        String id = "";
        for (int i = 0; i < grdPn.getColumnCount(); i++) {
            for (int j = 0; j < grdPn.getRowCount(); j++) {
                k  = i * game.getFIELDWIDTHLENGTH() + j;
                id = String.valueOf(k);
                Pane pane = new Pane();
                pane.setId(id);
                grdPn.add(pane, i, j);
            }
        }
        paintGrid();
    }

    /**
     * recolor the gridPane
     */
    private void paintGrid () {
        int idx;
        for (int x = 0; x < grdPn.getColumnCount(); x++) {
            for (int y = 0; y < grdPn.getRowCount(); y++) {
                idx = x * game.getFIELDWIDTHLENGTH() + y;
                Pane pane = (Pane) grdPn.getChildren().get(x * game.getFIELDWIDTHLENGTH() + y);
                if (idx % 2 == 0) {
                    pane.setBackground(new Background(
                            new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    pane.setBackground(new Background(
                            new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    /**
     * reColor the given InputImage to the given color and rotate it for 180°
     *
     * @param inputImage the image that should be change
     * @param finalColor the color for the final image
     *
     * @return reColored Image
     */
    public static Image reColorAndRotate (Image inputImage, java.awt.Color finalColor) {
        int           width       = (int) inputImage.getWidth();
        int           height      = (int) inputImage.getHeight();
        WritableImage outputImage = new WritableImage(width, height);
        PixelReader   reader      = inputImage.getPixelReader();
        PixelWriter   writer      = outputImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int            argb       = reader.getArgb(x, y);
                java.awt.Color pixelColor = new java.awt.Color(argb, true);
                writer.setArgb(height - 1 - x, width - 1 - y,
                        pixelColor.getRed() < finalColor.getRed() && pixelColor.getAlpha() != 0
                                ? finalColor.getRGB() : pixelColor.getRGB());
            }
        }
        return outputImage;
    }

    /**
     * initialise the preparation of the Race
     */
    @FXML public void initStartGame (ActionEvent actionEvent) {
        MenuItem target = (MenuItem) actionEvent.getSource();
        int      choice = 0;
        switch (target.getId()) {
            case "miVar1" -> choice = 1;
            case "miVar2" -> choice = 2;
            case "miVar3" -> choice = 3;
            case "miVar4" -> choice = 4;
            case "miVar5" -> choice = 5;
            default -> {
            }
        }
        game = new Game(choice,
                new JavaFXGUI(field, lblWinnerYou, lblWinnerAi, lblPointsYou, lblPointsAi, grdPn));
        resetGridPane(game.getFIELDWIDTHLENGTH(), game.getFIELDWIDTHLENGTH());
        field = initImages(grdPn, game.getGameField());

        grdPn.setDisable(false);
    }

    /**
     * Creates an array of imageviews corresponding to the gridPane. Each imageView becomes a child
     * of the gridPane and fills a cell. For proper resizing it is binded to the gridPanes width and
     * height. If the GridPane has a hgap or a vgap it is necessary to also consider these when
     * binding. A default image could be added by passing another parameter into this method.
     *
     * @param grdPn the GridPane to which ImageViews should be added
     *
     * @return an array of imageviews added to the gridPane
     */
    private ImageView[][] initImages (GridPane grdPn, StoneHolder[][] symbols) {
        Image Herzmuschel    = new Image("gui/img/Muschel.png");
        Image redHerzmuschel = reColorAndRotate(Herzmuschel, java.awt.Color.RED);
        Image Seestern       = new Image("gui/img/Seestern.png");
        Image redSeestern    = reColorAndRotate(Seestern, java.awt.Color.RED);
        Image Moewe          = new Image("gui/img/Moewe.png");
        Image redMoewe       = reColorAndRotate(Moewe, java.awt.Color.RED);
        Image Robbe          = new Image("gui/img/Robbe.png");
        Image redRobbe       = reColorAndRotate(Robbe, java.awt.Color.RED);

        int colcount  = symbols.length;
        int rowcount = symbols[0].length;

        field = new ImageView[colcount][rowcount];

        for (int x = 0; x < colcount; x++) {
            for (int y = 0; y < rowcount; y++) {
                field[x][y] = new ImageView();
                switch (symbols[x][y].getStone()) {
                    case MEER -> {
                    }
                    case HERZMUSCHEL1 -> {
                        field[x][y] = createImageView(Herzmuschel);
                    }
                    case HERZMUSCHEL2 -> {
                        field[x][y] = createImageView(redHerzmuschel);
                    }
                    case MOEWE1 -> {
                        field[x][y] = createImageView(Moewe);
                    }
                    case MOEWE2 -> {
                        field[x][y] = createImageView(redMoewe);
                    }
                    case SEESTERN1 -> {
                        field[x][y] = createImageView(Seestern);
                    }
                    case SEESTERN2 -> {
                        field[x][y] = createImageView(redSeestern);
                    }
                    case ROBBE1 -> {
                        field[x][y] = createImageView(Robbe);
                    }
                    case ROBBE2 -> {
                        field[x][y] = createImageView(redRobbe);
                    }
                }
                //add the imageview to the cell and assign the correct indicees for
                //this imageview, so you later can use GridPane.getColumnIndex(Node)
                grdPn.add(field[x][y], x, y);

                bindImgVwToGrdPn(field[x][y]);
            }
        }
        return field;
    }

    @FXML public void fileToLoad () {
        Stage       primaryStage = new Stage();
        FileChooser fileChooser  = openFolder();
        File        chosenFile   = fileChooser.showOpenDialog(primaryStage);
        if (chosenFile != null) {
            game = new Game(chosenFile.getName(),
                    new JavaFXGUI(field, lblWinnerYou, lblWinnerAi, lblPointsYou, lblPointsAi,
                            grdPn));
            resetGridPane(game.getFIELDWIDTHLENGTH(), game.getFIELDWIDTHLENGTH());
            field = initImages(grdPn, game.getGameField());
            grdPn.setDisable(false);
        }
    }

    @FXML public void fileToSave () {
        Stage       primaryStage = new Stage();
        FileChooser fileChooser  = openFolder();
        File        chosenFile   = fileChooser.showSaveDialog(primaryStage);
        if (chosenFile != null && game != null) {
            game.saveGame(chosenFile.getName());
        }
    }

    /**
     * Opens the saves-folder and create it when it is not existing
     */
    public FileChooser openFolder () {
        Stage       primaryStage = new Stage();
        FileChooser fileChooser  = new FileChooser();

        primaryStage.setTitle("File Chooser Example");
        File folder = null;
        try {
            folder = new File(
                    this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        fileChooser.setTitle("Chose a Game");

        fileChooser.setInitialDirectory(folder.getParentFile().getParentFile());
        fileChooser.setInitialDirectory(new File(fileChooser.getInitialDirectory() + "/saves/"));

        // Überprüfen, ob der Ordner existiert
        if (!fileChooser.getInitialDirectory().exists()) {
            // Falls nicht, den Ordner erstellen
            if (!fileChooser.getInitialDirectory().mkdirs()) {
                System.err.println("Fehler beim Erstellen des Ordners: saves");
                return null;
            }
        }

        fileChooser.getExtensionFilters()
                .addAll(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        return fileChooser;
    }

    /**
     * Reaction to the mouse click event on the menuItem Close Game (miCG).
     */
    @FXML private void closeGame () {
        System.exit(0);
    }

    /**
     * creates an image with the setup for the drag and drop
     *
     * @param image the Image for the ImageView
     *
     * @return imageView
     */
    private ImageView createImageView (Image image) {
        ImageView imgView = new ImageView(image);
        setupDragAndDrop(imgView);
        return imgView;
    }

    /**
     * setup for a drag and drop function for Images in a gridpane
     *
     * @param imgView the imageView for the image
     */
    private void setupDragAndDrop (ImageView imgView) {
        dragDetected(imgView);
        dragDone(imgView);
        dragOver();
        dragDropped();
    }

    /**
     * drag detected methode of an image in the gridpane
     *
     * @param imgView the imageView of an image in the gridpane
     */
    private void dragDetected (ImageView imgView) {
        imgView.setOnDragDetected(event -> {
            Position start =
                    new Position(GridPane.getColumnIndex(imgView), GridPane.getRowIndex(imgView));

            if (game.isStoneOwn(start)) {
                Dragboard db = imgView.startDragAndDrop(TransferMode.MOVE);

                ClipboardContent content = new ClipboardContent();
                content.putImage(imgView.getImage());
                content.putString(
                        GridPane.getColumnIndex(imgView) + "," + GridPane.getRowIndex(imgView));
                db.setContent(content);

                db.setDragView(imgView.getImage());

                game.handleDragStart(grdPn, imgView, start);

            }
            event.consume();
        });
    }

    /**
     * drag done methode of an image in the gridpane
     *
     * @param imgView the imageView for the image
     */
    private void dragDone (ImageView imgView) {
        imgView.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                grdPn.getChildren().remove(imgView);
                paintGrid();
            }
            event.consume();
        });
    }

    /**
     * drag over methode of an image in the gridpane
     */
    private void dragOver () {
        grdPn.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != grdPn && event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
    }

    /**
     * drag dropped methode of an image in the gridpane
     */
    private void dragDropped () {
        grdPn.setOnDragDropped(event -> {
            Dragboard db       = event.getDragboard();
            boolean   success  = false;
            boolean   possible = false;
            boolean   attacks  = false;
            if (db.hasImage()) {
                ImageView droppedImageView = game.handleDragDrop(db, grdPn, event);
                bindImgVwToGrdPn(droppedImageView);

                setupDragAndDrop(droppedImageView);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
            resetGridPane(game.getFIELDWIDTHLENGTH(), game.getFIELDWIDTHLENGTH());
            field = initImages(grdPn, game.getGameField());
/*            if (attacks) {
            }*/
        });
    }

    /**
     * bind the size of the image to the cell of the gridPane
     *
     * @param imgVw the imageView
     */
    private void bindImgVwToGrdPn (ImageView imgVw) {
        imgVw.fitHeightProperty().bind(grdPn.heightProperty().divide(game.getFIELDWIDTHLENGTH())
                .subtract(grdPn.getVgap()));

        imgVw.fitWidthProperty().bind(grdPn.widthProperty().divide(game.getFIELDWIDTHLENGTH())
                .subtract(grdPn.getHgap()));
    }

    @FXML private void openHandbook () {
        File currDir = null;

        try {
            currDir = new File(
                    this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException ex) {
            //oops... ¯\_(ツ)_/¯
            //guess we won't be opening the dialog in the right directory
        }

        FileChooser fileChooser = new FileChooser();

        if (currDir != null) {
            //ensure the dialog opens in the correct directory
            fileChooser.setInitialDirectory(currDir.getParentFile().getParentFile());
            fileChooser.setInitialDirectory(new File(fileChooser.getInitialDirectory()
                    + "/src/main/resources/handbook/Ostseeschach Spielregel Deutsch.pdf"));
            currDir = fileChooser.getInitialDirectory();
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(currDir);
            } else {
                System.err.println("PDF-Datei kann nicht angezeigt werden!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Prints width and height of gridPane when clicking it.
     *
     * @param mouseEvent not used
     */
    @FXML private void onGrdPnMouseClicked (MouseEvent mouseEvent) {
        System.out.printf("width/height: %5.1f/%5.1f%n", grdPn.getWidth(), grdPn.getHeight());
    }
}
