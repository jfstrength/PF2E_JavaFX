package controllers;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import models.Adventurer;
import com.fasterxml.jackson.databind.*;
import models.Feat;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class FeatWindowController implements Initializable {

    @FXML
    private ScrollPane container;
    @FXML
    private VBox rightContainer;

    private Adventurer adventurer;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        openChoice("data/feats/general");
    }


    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    private void openChoice(String fileName) {
        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(4);
        ObservableList<Node> list = content.getChildren();
        try {
           ObjectMapper objectMapper = new ObjectMapper();
           ClassLoader classLoader = FeatWindowController.class.getClassLoader();
           File folder = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
           System.out.println(folder.exists());
            for(final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
               Feat feat = objectMapper.readValue(fileEntry, Feat.class);
               Label label = new Label(feat.getFeatName());
               label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent mouseEvent) {
                       rightContainer.getChildren().clear();
                       Label description = new Label(feat.getDescription());
                       description.setWrapText(true);
                       rightContainer.getChildren().add(description);
                       rightContainer.setFillWidth(true);
                   }
               });
                label.setPadding(new Insets(3,3,3,3));
                label.setBorder(new Border(new BorderStroke(Color.FORESTGREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
               list.add(label);
           }
           container.setContent(content);
           container.setPannable(true);
           container.setFitToWidth(true);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
