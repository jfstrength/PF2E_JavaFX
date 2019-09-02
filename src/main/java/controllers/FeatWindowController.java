package controllers;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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

    private FeatsTabController parentController;
    private String currentItem;
    private Adventurer adventurer;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        openChoice("data/feats/general",container,rightContainer);
    }

    public void setParentController(FeatsTabController parentController) {
//        Get Domain Object from Parent Controller
        setAdventurer(parentController.getAdventurer());
        setParent(parentController);
    }

    public void setParent(FeatsTabController parentController) {
        this.parentController = parentController;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public String getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(String currentItem) {
        this.currentItem = currentItem;
    }

    private void openChoice(String fileName, ScrollPane container, VBox rightContainer) {
        VBox content = new VBox(4);
        content.setAlignment(Pos.CENTER);
        ObservableList<Node> list = content.getChildren();

        try {
           ObjectMapper objectMapper = new ObjectMapper();
           ClassLoader classLoader = FeatWindowController.class.getClassLoader();
           File folder = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

            for(final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
               Feat feat = objectMapper.readValue(fileEntry, Feat.class);
               Label label = new Label(feat.getFeatName());
               label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent mouseEvent) {
                       setCurrentItem(feat.getFeatName());
                       rightContainer.getChildren().clear();
                       Label description = new Label(feat.getDescription());
                       description.setWrapText(true);
                       rightContainer.getChildren().add(description);
                   }
               });
                label.setPadding(new Insets(3,3,3,3));
                label.setBorder(new Border(new BorderStroke(Color.FORESTGREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
                list.add(label);
           }
           container.setContent(content);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static Feat loadItem(String fileName) {
        fileName = fileName.replaceAll("\\s+","");
        if(!fileName.endsWith(".json"))
            fileName += ".json";
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = FeatWindowController.class.getClassLoader();
        fileName = "data/feats/general/" + fileName;
        final File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return objectMapper.readValue(file, Feat.class);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private void addChoice() {
        setCurrentItem(getCurrentItem().replaceAll("\\s+",""));
        if(!getCurrentItem().endsWith(".json"))
            setCurrentItem(getCurrentItem()+".json");
        Feat newFeat = loadItem(getCurrentItem());
        if(adventurer.hasFeat(newFeat)) {
            System.out.println("Already has that feat");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Preexisting feat");
            alert.setHeaderText("Feat not added");
            alert.setContentText("This character already has that feat.");
            alert.showAndWait();
            return; }
        adventurer.getFeats().add(newFeat);
        parentController.listFeats();
    }


}
