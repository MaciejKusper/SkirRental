package skirental;


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.BorderPane;
        import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/BorderPaneMain.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane , 800 , 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ski Rental");
        primaryStage.show();
    }
}
