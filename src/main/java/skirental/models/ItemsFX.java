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
    private IntegerProperty condition = new SimpleIntegerProperty();
}
