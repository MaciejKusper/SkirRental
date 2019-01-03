package skirental.models;

import javafx.beans.property.*;

public class ItemsFX {


    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty external_id = new SimpleStringProperty();
    private StringProperty type = new SimpleStringProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private StringProperty size = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private BooleanProperty inStock = new SimpleBooleanProperty();


}
