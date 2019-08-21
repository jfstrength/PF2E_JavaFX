package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class FeatsTabController implements Initializable {

    @Override public void initialize(URL url, ResourceBundle rb) {
    }

    public void newButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/FeatWindow.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
