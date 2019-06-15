package skirental.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import skirental.utils.DialogsUtils;
import skirental.utils.FxmlUtils;
import java.util.Optional;

public class MainController {


    @FXML
    private BorderPane borderPane;
    @FXML
    private TopMenuController topMenuController;
    @FXML
    private void initialize()
    {
    topMenuController.setMainController(this);
        borderPane.setCenter(FxmlUtils.fxmlLoader("/fxml/MainMain.fxml"));
    }

    public void setCenter(String fxmlPath){
        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
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
