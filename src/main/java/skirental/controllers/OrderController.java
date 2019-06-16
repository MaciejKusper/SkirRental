package skirental.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.*;
import skirental.utils.DialogsUtils;


import java.util.List;

public class OrderController {

    @FXML
    private Button newOrderButton;

    @FXML
    private Button addNewCustomerButton;

    @FXML
    private Button insertItem;

    @FXML
    private ComboBox<CustomerFX> selectCustomerComboBox;

    @FXML
    private TextField addItemsTextField;

    @FXML
    private Button saveOrderButton;

    @FXML
    private Button calculate;
    @FXML
    private TextField searchCustomerTextField;

    @FXML
    private Button searchCustomerButton;

    @FXML
    private Label orderSum;

    @FXML
    private Label orderNumber;

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
    private OrderModel orderModel;

    @FXML
    private  void initialize() throws ApplicationException {

        this.customerModel = new CustomerModel();
        this.itemsModel = new ItemsModel();
        this.orderModel = new OrderModel();
       //this.itemsModel.takeItemsFromDB();
        //this.customerModel.takeCustomerFromDB();
       //this.orderModel.takeLastOrderFromDatabase();
      // orderNumber.setText("" +this.orderModel.orderIdProperty.getValue());
        initBinding();
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
        addItemsTextField.textProperty().addListener((observable, oldValue, newValue) -> {

            System.out.println(" Text Changed to  " + newValue + ")\n");
            if(newValue.length()==10){
                try {
                    itemsModel.takeRFIDFromDB(addItemsTextField.getText());
                    addItemsTextField.clear();
                } catch (ApplicationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    void addNewCustomer() throws ApplicationException {
        DialogsUtils.addCustomerDialog();
        initialize();
}

    @FXML
    void newOrder() throws ApplicationException {
        this.orderModel = new OrderModel();
        orderModel.saveOrderToDatabase();
        orderModel.takeLastOrderFromDatabase();
        orderNumber.setText("" +this.orderModel.orderIdProperty.getValue());
        //this.itemsModel.setItemsFXObservableList(null);
}
    @FXML
    void saveOrder() throws ApplicationException {
        orderModel.takeLastOrderFromDatabase();
        System.out.println(this.orderModel.orderFXObjectProperty.toString());
        this.itemsModel.orderItems(this.itemsModel.getItemsFXObservableList(),this.orderModel.orderFXObjectProperty,this.customerModel.customerProperty());
        DialogsUtils.addOrderDialog(orderNumber.getText());
        addItemsTextField.clear();
        orderNumber.setText(null);
        orderSum.setText("-");
    }


    public void selectedOnComboBox() {
        this.customerModel.setCustomer(this.selectCustomerComboBox.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void addNewItem() throws ApplicationException {
            this.itemsModel.takeRFIDFromDB(addItemsTextField.getText());
             addItemsTextField.clear();
    }
    private void initBinding() {
        saveOrderButton.disableProperty().bind(selectCustomerComboBox.valueProperty().isNull());
        addNewCustomerButton.disableProperty().bind(orderNumber.textProperty().isEmpty());
        insertItem.disableProperty().bind(orderNumber.textProperty().isEmpty());
        selectCustomerComboBox.disableProperty().bind(orderNumber.textProperty().isEmpty());
        calculate.disableProperty().bind(orderNumber.textProperty().isEmpty());
        addItemsTextField.disableProperty().bind(orderNumber.textProperty().isEmpty());
        searchCustomerButton.disableProperty().bind(searchCustomerTextField.textProperty().isEmpty().or(orderNumber.textProperty().isEmpty()));
    }

    public void calculateButton() {
        double sum = 0.0;
        List<ItemsFX> list = this.itemsModel.getItemsFXObservableList();
        for (ItemsFX itemsFX : list) {
            sum += itemsFX.getPrice();
        }
        orderSum.setText(""+sum);
    }

    public void searchCustomer() throws ApplicationException {
        customerModel.takeCustomerByRFIDFromDB(searchCustomerTextField.getText());
    }
}