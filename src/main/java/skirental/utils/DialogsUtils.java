package skirental.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {

    static ResourceBundle bundle = ResourceBundle.getBundle("bundle.messages");
    public static void aboutDialog(){
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle(bundle.getString("aboutDialog.title"));
        infoAlert.setHeaderText(bundle.getString("aboutDialog.header"));
        infoAlert.setContentText(bundle.getString("aboutDialog.text"));
        infoAlert.showAndWait();
    }


    public static Optional<ButtonType> exitDialog(){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle(bundle.getString("exitDialog.title"));
        exitAlert.setHeaderText(bundle.getString("exitDialog.header"));
        Optional<ButtonType> result = exitAlert.showAndWait();
        return result;
    }
}
