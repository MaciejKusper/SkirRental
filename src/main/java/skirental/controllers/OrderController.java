package skirental.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.CustomerFX;
import skirental.models.CustomerModel;
import skirental.utils.DialogsUtils;

public class OrderController {

    @FXML
    private Button newOrderButton;

    @FXML
    private ComboBox<CustomerFX> selectCustomerComboBox;

    @FXML
    private Button addNewCustomerButton;

    @FXML
    private TextField addItemsTextField;

    @FXML
    private Button saveOrderButton;

    private CustomerModel customerModel;

    @FXML
    private  void initialize() throws ApplicationException {
        this.customerModel = new CustomerModel();
        this.customerModel.takeCustomerFromDB();
        this.selectCustomerComboBox.setItems(this.customerModel.getCustomerFXObservableList());
    }

    @FXML
    void addItemsListener() {

    }

    @FXML
    void addNewCustomer() throws ApplicationException {
        DialogsUtils.addCustomerDialog();
        initialize();
}

    @FXML
    void newOrder() {

    }

    @FXML
    void saveOrder() {

    }

}