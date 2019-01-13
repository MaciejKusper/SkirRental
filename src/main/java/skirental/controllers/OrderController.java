package skirental.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.CustomerFX;
import skirental.models.CustomerModel;
import skirental.models.ItemsFX;
import skirental.models.ItemsModel;
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

    @FXML
    private TableView<ItemsFX> orderTableView;

    @FXML
    private TableColumn<ItemsFX, String> rfidTableColumn;

    @FXML
    private TableColumn<ItemsFX, String> typeTabelColumn;

    @FXML
    private TableColumn<ItemsFX, Double> priceTableColumn;

    @FXML
    private TableColumn<ItemsFX, String> sizeTableColumn;

    @FXML
    private TableColumn<ItemsFX, String> descriptionTableColumn;


    private CustomerModel customerModel;
    private ItemsModel itemsModel;

    @FXML
    private  void initialize() throws ApplicationException {

        this.customerModel = new CustomerModel();
        this.itemsModel = new ItemsModel();
        this.itemsModel.takeItemsFromDB();
        this.customerModel.takeCustomerFromDB();
        this.selectCustomerComboBox.setItems(this.customerModel.getCustomerFXObservableList());
        this.orderTableView.setItems(this.itemsModel.getItemsFXObservableList());
        this.rfidTableColumn.setCellValueFactory(cellData-> cellData.getValue().external_idProperty());
        this.typeTabelColumn.setCellValueFactory(cellData-> cellData.getValue().typeProperty());
        this.priceTableColumn.setCellValueFactory(cellData-> cellData.getValue().priceProperty().asObject());
       this.sizeTableColumn.setCellValueFactory(cellData-> cellData.getValue().sizeProperty());
       this.descriptionTableColumn.setCellValueFactory(cellData-> cellData.getValue().descriptionProperty());



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

    public void deleteCustomer() throws ApplicationException {
        DialogsUtils.deleteCustomerDialog();
        initialize();
    }

    public void selectedOnComboBox(ActionEvent actionEvent) {
        this.customerModel.setCustomer(this.selectCustomerComboBox.getSelectionModel().getSelectedItem());
    }
}