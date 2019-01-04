package skirental.models;
import javafx.beans.property.*;

import java.time.LocalDate;

public class CustomerFX {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty external_id = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private StringProperty sddres = new SimpleStringProperty();
    private SimpleObjectProperty<LocalDate> addedDate = new SimpleObjectProperty<>();

}
