package skirental.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {



    @FXML
    private BorderPane borderPane;
    @FXML
    private TopMenuController topMenuController;
    @FXML
    private void initialize()
    {
    topMenuController.setMainController(this);
    }

    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        borderPane.setCenter(parent);
    }
}
