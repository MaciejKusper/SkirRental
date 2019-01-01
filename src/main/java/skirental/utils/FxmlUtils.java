package skirental.utils;

import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlUtils {


    //Method to load fxml files
    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getClass().getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();

        } catch (Exception e) {

            DialogsUtils.errorDialog(e.getMessage());
        }
        return null;

    }

    //Method to load resorceBundle
    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle.messages");
    }
}