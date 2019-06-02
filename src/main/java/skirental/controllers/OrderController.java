package skirental.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.omg.CORBA.portable.ApplicationException;
import skirental.database.model.Items;
import skirental.models.*;
import skirental.utils.DialogsUtils;

import java.util.List;

public class OrderController {

    @FXML
    private Button newOrderButton;

    @FXML
    private ComboBox<CustomerFX> selectCustomerComboBox;

    @FXML
    private Button addNewCustomerButton;

    @FXML
    private Button insertItem;

    @FXML
    private TextField addItemsTextField;

    @FXML
    private Button saveOrderButton;

    @FXML
    private Label orderSum;


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
        this.itemsModel.takeItemsFromDB();
        this.customerModel.takeCustomerFromDB();
        this.orderModel.takeOrderFromDatabase();
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
    void newOrder() throws ApplicationException {
        this.orderModel = new OrderModel();
        orderModel.saveOrderToDatabase();


}


    @FXML
    void saveOrder() throws ApplicationException {
        Double sum = new Double(0.0);
        List<ItemsFX> list = this.itemsModel.getItemsFXObservableList();
        for(Integer i= 0 ;i < list.size() ; i++) {
            sum += list.get(i).getPrice();
        }

        orderSum.setText(""+sum);
        orderModel.takeOrderFromDatabase();
        System.out.println(this.orderModel.orderFXObjectProperty.toString());


    }

    public void deleteCustomer() throws ApplicationException {
        DialogsUtils.deleteCustomerDialog();
        initialize();
    }

    public void selectedOnComboBox(ActionEvent actionEvent) {
        this.customerModel.setCustomer(this.selectCustomerComboBox.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void addNewItem(ActionEvent actionEvent) throws ApplicationException {
            this.itemsModel.takeRFIDFromDB(addItemsTextField.getText());
    }
}