package skirental.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import skirental.controllers.OrderController;
import skirental.models.CustomerModel;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {

    static ResourceBundle bundle = FxmlUtils.getResourceBundle();
    private static final String CUSTOMER_FXML = "/fxml/Customer.fxml";

    public static void aboutDialog(){
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle(bundle.getString("aboutDialog.title"));
        infoAlert.setHeaderText(bundle.getString("aboutDialog.header"));
        infoAlert.setContentText(bundle.getString("aboutDialog.text"));
        infoAlert.showAndWait();
    }

    public static void addCustomerDialog(){
        Alert addAlert = new Alert(Alert.AlertType.CONFIRMATION);
        addAlert.setTitle(bundle.getString("addCustomerDialog.title"));
        addAlert.setHeaderText(bundle.getString("addCustomerDialog.header"));
        Pane pane = FxmlUtils.fxmlLoader(CUSTOMER_FXML);
        addAlert.getDialogPane().setContent(pane);
        addAlert.showAndWait();

    }

    public static Optional<ButtonType> exitDialog(){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle(bundle.getString("exitDialog.title"));
        exitAlert.setHeaderText(bundle.getString("exitDialog.header"));
        Optional<ButtonType> result = exitAlert.showAndWait();
        return result;
    }

    public static void errorDialog(String error){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("errorDialog.title"));
        errorAlert.setHeaderText(bundle.getString("errorDialog.header"));
        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }
}
