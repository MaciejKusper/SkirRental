package skirental;


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.BorderPane;
        import javafx.stage.Stage;

        import java.util.ResourceBundle;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(BORDER_PANE_MAIN_FXML));
        ResourceBundle bundle = ResourceBundle.getBundle("bundle.messages");
        loader.setResources(bundle);
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane , 800 , 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle(bundle.getString("tittle.application"));
        primaryStage.show();
    }
}
