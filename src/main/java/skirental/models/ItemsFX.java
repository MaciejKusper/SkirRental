package skirental.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class ItemsFX {


    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty external_id = new SimpleStringProperty();
    private StringProperty type = new SimpleStringProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private StringProperty size = new SimpleStringProperty();
    private SimpleObjectProperty<LocalDate> addedDate = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> serviceDate = new SimpleObjectProperty<>();
    private StringProperty description = new SimpleStringProperty();


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getExternal_id() {
        return external_id.get();
    }

    public StringProperty external_idProperty() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id.set(external_id);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public LocalDate getAddedDate() {
        return addedDate.get();
    }

    public SimpleObjectProperty<LocalDate> addedDateProperty() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate.set(addedDate);
    }

    public LocalDate getServiceDate() {
        return serviceDate.get();
    }

    public SimpleObjectProperty<LocalDate> serviceDateProperty() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate.set(serviceDate);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }



}
