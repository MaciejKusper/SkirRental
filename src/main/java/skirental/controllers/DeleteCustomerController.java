package skirental.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import org.omg.CORBA.portable.ApplicationException;
import skirental.models.CustomerFX;
import skirental.models.CustomerModel;

public class DeleteCustomerController {

    private CustomerModel customerModel;


    @FXML
    private ComboBox<CustomerFX> customerComboBox;

    @FXML
    private Button deleteButton;

    @FXML
    void delete() throws ApplicationException {
        this.customerModel.deleteCustomerFromDB();
    }
    @FXML
    private  void initialize() throws ApplicationException {
        this.customerModel = new CustomerModel();
        this.customerModel.takeCustomerFromDB();
        this.customerComboBox.setItems(this.customerModel.getCustomerFXObservableList());
        binding();
    }

    private void binding(){
        deleteButton.disableProperty().bind(this.customerModel.customerProperty().isNull());
    }

    @FXML
    void onActionComboBox() {
        this.customerModel.setCustomer(this.customerComboBox.getSelectionModel().getSelectedItem());
    }

}

