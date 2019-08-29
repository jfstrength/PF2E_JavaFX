package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Adventurer adventurer;

    @FXML
    private AbilitiesTabController abilitiesTabController;
    @FXML
    private FeatsTabController featsTabController;

    @FXML
    private Label str;


    @Override public void initialize(URL url, ResourceBundle rb) {
        //Initialize Domain Object
        adventurer = new Adventurer();

        //Pass model to Tabs via Parent Controller
        abilitiesTabController.setParentController(this);
        featsTabController.setParentController(this);

    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setStrLabel() {
        str.setText(Integer.toString(adventurer.getStrength()));
    }
}
