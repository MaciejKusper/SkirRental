package skirental.database.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.Date;

public class Customer {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "EXTERNAL_ID", canBeNull = false)
    private String external_id;

    @DatabaseField(columnName = "TYPE")
    private String type;

    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "SURNAME", canBeNull = false)
    private String surname;

    @DatabaseField(columnName = "ADDERS")
    private String addres;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    @DatabaseField(columnName = "COMMENTS")
    private String comments;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Items> item;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ForeignCollection<Items> getItem() {
        return item;
    }

    public void setItem(ForeignCollection<Items> item) {
        this.item = item;
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
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addres='" + addres + '\'' +
                ", addedDate=" + addedDate +
                ", comments='" + comments + '\'' +
                ", item=" + item +
                '}';
    }
}
