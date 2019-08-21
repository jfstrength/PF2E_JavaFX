package controllers;

import javafx.fxml.Initializable;
import models.Adventurer;
import java.net.URL;
import java.util.ResourceBundle;

public class FeatWindowController implements Initializable {


    private Adventurer adventurer;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }


    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
}
