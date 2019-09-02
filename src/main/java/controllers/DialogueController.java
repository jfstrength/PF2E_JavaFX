package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Feat;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogueController implements Initializable {

    @FXML
    private Label label;

    private Feat feat;

    public DialogueController(Feat entry) {
        this.feat = entry;
    }

    public DialogueController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(feat.getDescription());
    }
}
