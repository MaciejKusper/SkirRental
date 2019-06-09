package skirental.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.CustomerModel;
import skirental.models.ItemsFX;
import skirental.models.ItemsModel;
import skirental.models.OrderModel;
import skirental.utils.Converters;

import java.util.List;

public class ReturnController {


    @FXML
    private Label orderNumber;

    @FXML
    private TextField takeOrder;

    @FXML
    private Button searchOrderButton;

    @FXML
    private Label customerLabel;

    @FXML
    private TextField addItemsTextField;

    @FXML
    private Button insertItem;

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

    @FXML
    private Label nuberHouerLable;

    @FXML
    private Label orderSum;

    @FXML
    private Button calculate;

    @FXML
    private Button returnButton;

    private CustomerModel customerModel;
    private ItemsModel itemsModel;
    private OrderModel orderModel;

    @FXML
    private  void initialize() throws ApplicationException {

        this.customerModel = new CustomerModel();
        this.itemsModel = new ItemsModel();
        this.orderModel = new OrderModel();
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
    void addNewItem() {

    }

    @FXML
    void calculateButton() {
        double sum = 0.0;
        double hour = 1;
        List<ItemsFX> list = this.itemsModel.getItemsFXObservableList();
        for (ItemsFX itemsFX : list) {
            sum += itemsFX.getPrice();
        }
        sum = sum*hour;
        orderSum.setText(""+sum);
    }


    @FXML
    void saveOrder() {

    }

    @FXML
    void searchOrder() throws ApplicationException {

        this.orderModel.takeOrderByID(Converters.convertToInteger(takeOrder.getText()));
        orderNumber.setText(""+orderModel.returnOrderIdProperty.get());
        //orderNumber.setText(""+Integer.parseInt(takeOrder.getText()));
        itemsModel.takeByOrderIdFromDB(orderModel.returnOrderIdProperty.get());
        customerModel.takeCustomerByID(itemsModel.getCustomerId());
        if (customerModel.getCustomerStr()!=null) {
            customerLabel.setText(customerModel.getCustomerStr().getName() + customerModel.getCustomerStr().getSurname());
        }
    }

}
