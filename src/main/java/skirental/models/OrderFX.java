package skirental.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderFX {


    private IntegerProperty id = new SimpleIntegerProperty();


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }
    @Override
    public String toString() {
        return "OrderFX{" +
                "id=" + id +
                '}';
    }

}
