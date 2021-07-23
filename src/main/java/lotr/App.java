package lotr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App extends Application {

    private TextField outputCodes;
    private TextField outputNames;
    private List<Character> characters = new ArrayList<>();

    @Override
    public void start(Stage mainStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5, 5, 5, 5));

        int rowIndex = 0;
        int colIndex = 0;

        for (int i = 0; i < Characters.getCharacters().size(); i++) {
            if (i % 6 == 0) {
                rowIndex++;
                colIndex = 0;
            }
            grid.add(new CharacterButton(Characters.getCharacters().get(i)), colIndex++, rowIndex);
        }

        outputCodes = new TextField();
        outputCodes.setOnMouseClicked(event -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(outputCodes.getText());
            clipboard.setContent(content);
        });

        outputNames = new TextField();

        Button clear = new Button("Clear");
        clear.setMaxWidth(Double.MAX_VALUE);
        clear.setOnAction(a -> {
            outputCodes.clear();
            outputNames.clear();
            characters.clear();
        });

        VBox vbox = new VBox(grid, outputCodes, outputNames, clear);
        vbox.setSpacing(5);

        Scene scene = new Scene(vbox);

        mainStage.setTitle("Find a match");
        mainStage.setScene(scene);
        mainStage.show();
    }

    class CharacterButton extends Button {

        public CharacterButton(Character character) {
            super(character.getName());
            this.setMinWidth(120);
            this.setOnAction(a -> {
                if (characters.contains(character)) {
                    return;
                }
                characters.add(character);

                StringBuilder sbCodes = new StringBuilder();
                StringBuilder sbNames = new StringBuilder();

                characters.stream()
                        .sorted(Comparator.comparingInt(Character::getIndex))
                        .forEach(c -> {
                            sbCodes.append(c.getCode()).append(" ");
                            sbNames.append(c.getName()).append(" ");
                        });

                outputCodes.setText(sbCodes.toString().trim());
                outputNames.setText(sbNames.toString().trim());
            });
        }
    }
}
