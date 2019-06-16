package skirental.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.omg.CORBA.portable.ApplicationException;
import skirental.models.CustomerModel;
import skirental.models.ItemsFX;
import skirental.models.ItemsModel;
import skirental.models.OrderModel;
import skirental.utils.Converters;
import skirental.utils.DialogsUtils;
import skirental.utils.FxmlUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static java.lang.Math.round;
import static java.lang.Math.toIntExact;

public class ReturnController {


    @FXML
    private Label orderNumber;

    @FXML
    private TextField takeOrder;

    @FXML
    private Label customerLabel;

    @FXML
    private Slider discountSlider;

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
    private Label numberHourLabel;

    @FXML
    private Label orderSum;

    @FXML
    private Label orderDateLabel;

    @FXML
    private Label orderDate;

    @FXML
    private Button calculate;

    @FXML
    private Button returnButton;

    private CustomerModel customerModel;
    private ItemsModel itemsModel;
    private OrderModel orderModel;
    private long duration;
    private Integer finalPrice;

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
        initBinding();
    }

    private void initBinding() {

        returnButton.disableProperty().bind(orderNumber.textProperty().isEmpty());
        calculate.disableProperty().bind(orderNumber.textProperty().isEmpty());
        discountSlider.disableProperty().bind(orderNumber.textProperty().isEmpty());
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
        long sum_f;
        double discount;

        discount = discountSlider.getValue();
        System.out.println(discount);
        List<ItemsFX> list = this.itemsModel.getItemsFXObservableList();
        for (ItemsFX itemsFX : list) {
            sum += itemsFX.getPrice();
        }
        if(duration>0) {
            sum_f = round(sum * duration * ((100 - discount) / 100));
        }
        else{
            sum_f = round(sum * ((100 - discount) / 100));
        }
        orderSum.setText(""+sum_f);
        finalPrice = toIntExact(sum_f);
    }


    @FXML
    void returnOrder() {
        this.orderModel.returnOrder(this.orderModel.returnOrderFXObjectProperty,finalPrice,this.customerModel.getCustomerStr().getExternal_id());
        this.itemsModel.returnItems(this.itemsModel.getItemsFXObservableList());
        DialogsUtils.returnOrderDialog(" "+finalPrice);
        orderDate.setText("-");
        orderNumber.setText("-");
        orderSum.setText(""+0);
        discountSlider.setValue(0);
        takeOrder.clear();
    }

    @FXML
    void searchOrder() throws ApplicationException {
        this.orderModel.takeOrderByID(Converters.convertToInteger(takeOrder.getText()));
        //if(orderModel.returnOrderFXObjectProperty == null){
        //    System.out.println("Nie istnieje takie zamowienie!");
       // }
        if(orderModel.returnOrderFXObjectProperty.get().getClientRfid() != null){
            DialogsUtils.orderReturnedDialog(" " + orderModel.returnOrderFXObjectProperty.get().getClientRfid()," " + orderModel.returnOrderFXObjectProperty.get().getOrderDate());
            takeOrder.clear();
        }
        else {
            orderNumber.setText("" + orderModel.returnOrderIdProperty.get());
            orderDate.setText("" + orderModel.returnOrderFXObjectProperty.get().getOrderDate());
            itemsModel.takeByOrderIdFromDB(orderModel.returnOrderIdProperty.get());
            customerModel.takeCustomerByID(itemsModel.getCustomerId());
            if (customerModel.getCustomerStr() != null) {
                customerLabel.setText(customerModel.getCustomerStr().getName() + customerModel.getCustomerStr().getSurname());
            }
            if (orderModel.returnOrderFXObjectProperty.get().getOrderDate() != null) {
                LocalDate orderDate = orderModel.returnOrderFXObjectProperty.get().getOrderDate();
                LocalDate today = LocalDate.now();
                duration = Duration.between(orderDate.atStartOfDay(), today.atStartOfDay()).toHours();
                numberHourLabel.setText("" + duration);
            }
        }

    }

}
