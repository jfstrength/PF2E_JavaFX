package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Adventurer;
import models.Feat;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class FeatsTabController implements Initializable {


    @FXML
    private ListView<String> container;
    @FXML
    private FeatWindowController featWindowController;

    private Adventurer adventurer;

    @Override public void initialize(URL url, ResourceBundle rb) {
        container.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount()==2) {
                    String item = container.getSelectionModel().getSelectedItem();
                    System.out.println(item);
                    Feat feat = FeatWindowController.loadItem(item);
                    try {
                        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("views/Dialogue.fxml"));
                        DialogueController dialogueController = new DialogueController(feat);
                        loader.setController(dialogueController);
                        Parent root = loader.load();
                        Stage dialogueStage = new Stage();
                        dialogueStage.setTitle(feat.getFeatName());
                        dialogueStage.setScene(new Scene(root,600,400));
                        dialogueStage.setAlwaysOnTop(true);
                        dialogueStage.setResizable(false);
                        dialogueStage.show();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }



    public void listFeats() {
        ObservableList<String> names = adventurer.getFeatNames();
        container.getItems().clear();
        container.setItems(names);
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
        //Show the feats
        listFeats();
    }

    public void setParentController(MainController parentController) {
        //Get Domain Object from Parent Controller
        setAdventurer(parentController.getAdventurer());
    }

    public ListView<String> getContainer() {
        return container;
    }

    public void newButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("views/FeatWindow.fxml"));
        FeatWindowController featWindowController = new FeatWindowController();
        featWindowController.setParentController(this);
        loader.setController(featWindowController);
        Parent root = loader.load();
        Stage primaryStage = new Stage();
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
