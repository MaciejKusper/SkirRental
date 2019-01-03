package skirental.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.CustomerModel;


public class CustomerController {

    @FXML
    private Button newCustomerButton;

    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField addresText;
    @FXML
    private TextField cardText;

    private CustomerModel customerModel;
    @FXML
    public void initialize(){
        this.customerModel = new CustomerModel();
    }

    public void addCustomer() throws ApplicationException {

        customerModel.saveCustomerToDB(nameText.getText(),surnameText.getText(),addresText.getText(),cardText.getText());
    }
}
