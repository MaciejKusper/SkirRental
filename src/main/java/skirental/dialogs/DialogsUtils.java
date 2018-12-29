package skirental.dialogs;

import javafx.scene.control.Alert;

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
}
