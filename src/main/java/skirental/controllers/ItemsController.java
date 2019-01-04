package skirental.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.ItemsModel;
import skirental.utils.Converters;
import skirental.utils.DialogsUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class ItemsController {

    @FXML
    private Button newItemButton;

    @FXML
    private TextField rfidText;

    @FXML
    private TextField typeText;

    @FXML
    private TextField priceText;

    @FXML
    private TextField sizeText;

    @FXML
    private DatePicker serviceDate;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Slider condition;


    private ItemsModel itemsModel;
    @FXML
    public void initialize(){

        this.itemsModel= new ItemsModel();

    }


    public void addItem() throws ApplicationException {
        itemsModel.saveItemToDB(rfidText.getText(), typeText.getText(), Converters.convertToDouble(priceText.getText()),sizeText.getText(), Converters.convertToDate(serviceDate.getValue()) , descriptionTextArea.getText(),condition.getValue());
    }




}


