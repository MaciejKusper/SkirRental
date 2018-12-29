package skirental.controllers;



public class TopMenuController {



    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void openMain() {
        System.out.println("open Main/n");
        mainController.setCenter("/fxml/MainMain.fxml");
    }

    public void openOrder() {
        System.out.println("open Order/n");
        mainController.setCenter("/fxml/MainOrder.fxml");
    }


}