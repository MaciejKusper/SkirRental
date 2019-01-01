package skirental.database.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Customer {

    @DatabaseField(generatedId = true)
    private int id;

    // @DatabaseField(columnName = AUTHOR_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    // private Author author;
    //@DatabaseField(columnName = CATEGORY_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    //private Category category;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
