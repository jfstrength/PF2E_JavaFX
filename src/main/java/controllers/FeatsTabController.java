package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
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
    }


    public void listFeats() {
        ObservableList<String> names = FXCollections.observableArrayList();
        List<Feat> feats = adventurer.getFeats();
        for (Feat feat : feats) {
            String name = feat.getFeatName();
            names.add(name);
        }
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

    public void printButton() {
        listFeats();
    }

    public void newButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("views/FeatWindow.fxml"));
        FeatWindowController featWindowController = new FeatWindowController();
        featWindowController.setParentController(this);
        loader.setController(featWindowController);
        Parent root = loader.load();
      //  Parent root = FXMLLoader.load(ClassLoader.getSystemResource("views/FeatWindow.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
