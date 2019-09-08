package skirental.database.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Customer implements BaseModel{

    public Customer() {
    }

    @DatabaseField(generatedId = true, unique = true)
    private int id;

    @DatabaseField(columnName = "EXTERNAL_ID", canBeNull = false)
    private String external_id;


    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "SURNAME", canBeNull = false)
    private String surname;

    @DatabaseField(columnName = "ADDRESS")
    private String address;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", external_id='" + external_id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
               // ", addedDate=" + addedDate +
                //", comments='" + comments + '\'' +
                //", item=" + item +
                '}';
    }
}
