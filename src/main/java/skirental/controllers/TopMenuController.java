package skirental.controllers;



public class TopMenuController {

    public static final String MAIN_MAIN_FXML = "/fxml/MainMain.fxml";
    public static final String MAIN_ORDER_FXML = "/fxml/MainOrder.fxml";

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void openMain() {
        System.out.println("open Main/n");
        mainController.setCenter(MAIN_MAIN_FXML);
    }

    public void openOrder() {
        System.out.println("open Order/n");
        mainController.setCenter(MAIN_ORDER_FXML);
    }


}