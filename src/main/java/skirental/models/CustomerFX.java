package skirental.models;
import javafx.beans.property.*;


import java.time.LocalDateTime;

public class CustomerFX {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty external_id = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private StringProperty addres = new SimpleStringProperty();
    private SimpleObjectProperty<LocalDateTime> addedDate = new SimpleObjectProperty<>();

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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getAddres() {
        return addres.get();
    }

    public StringProperty addresProperty() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres.set(addres);
    }

    public LocalDateTime getAddedDate() {
        return addedDate.get();
    }

    public SimpleObjectProperty<LocalDateTime> addedDateProperty() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate.set(addedDate);
    }

    @Override
    public String toString() {
        return name.getValue() + " " + surname.getValue() + " " + external_id.getValue();
    }
}