package skirental.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class OrderFX {


    private IntegerProperty id = new SimpleIntegerProperty();
    private SimpleObjectProperty<LocalDate> orderDate = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> returnDate = new SimpleObjectProperty<>();
    private IntegerProperty finalPrice = new SimpleIntegerProperty();
    private StringProperty clientRfid = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate.get();
    }

    public SimpleObjectProperty<LocalDate> orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate.set(orderDate);
    }

    public LocalDate getReturnDate() {
        return returnDate.get();
    }

    public SimpleObjectProperty<LocalDate> returnDateProperty() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate.set(returnDate);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getFinalPrice() {
        return finalPrice.get();
    }

    public IntegerProperty finalPriceProperty() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice.set(finalPrice);
    }

    public String getClientRfid() {
        return clientRfid.get();
    }

    public StringProperty clientRfidProperty() {
        return clientRfid;
    }

    public void setClientRfid(String clientRfid) {
        this.clientRfid.set(clientRfid);
    }
}
