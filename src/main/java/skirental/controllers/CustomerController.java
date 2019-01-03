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

        initBinding();
    }

    private void initBinding() {
        newCustomerButton.disableProperty().bind(nameText.textProperty().isEmpty().or(surnameText.textProperty().isEmpty()).or(cardText.textProperty().isEmpty()));
    }

    public void addCustomer() throws ApplicationException {

        customerModel.saveCustomerToDB(nameText.getText(),surnameText.getText(),addresText.getText(),cardText.getText());
        nameText.clear();
        surnameText.clear();
        addresText.clear();
        cardText.clear();


    }
}
