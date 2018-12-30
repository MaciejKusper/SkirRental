package skirental.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import skirental.dialogs.DialogsUtils;

import java.io.IOException;
import java.util.Optional;

import static skirental.dialogs.DialogsUtils.exitDialog;

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

    public void closeApplication(ActionEvent actionEvent) {
        Optional<ButtonType> result = DialogsUtils.exitDialog();
        if(result.get()==ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
    public void info() {
        DialogsUtils.aboutDialog();
        }

}
