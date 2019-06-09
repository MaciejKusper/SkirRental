package skirental.controllers;


import javafx.event.ActionEvent;

public class TopMenuController {

    private static final String MAIN_MAIN_FXML = "/fxml/MainMain.fxml";
    private static final String MAIN_ORDER_FXML = "/fxml/MainOrder.fxml";
    private static final String CUSTOMER_FXML = "/fxml/Customer.fxml";
    private static final String ITEMS_FXML ="/fxml/Items.fxml" ;
    private static final String ORDER_FXML ="/fxml/Order.fxml" ;
    private static final String RETURN_FXML ="/fxml/Return.fxml" ;


    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void openMain() {
        mainController.setCenter(MAIN_MAIN_FXML);
    }

    public void openOrder() {
        mainController.setCenter(ORDER_FXML);
    }

    public void openCustomer(){
        mainController.setCenter(CUSTOMER_FXML);
    }

    public void openItems() {
        mainController.setCenter(ITEMS_FXML);
    }

    public void openReturn(ActionEvent actionEvent) {
        mainController.setCenter(RETURN_FXML);
    }
}