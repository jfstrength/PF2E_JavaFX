package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }

    @FXML
    public void createButton(ActionEvent event) throws IOException {

        //Open new view in same window
        Parent root1 = FXMLLoader.load(ClassLoader.getSystemResource("views/Main.fxml"));
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(new Scene(root1));
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.show();
    }



}
