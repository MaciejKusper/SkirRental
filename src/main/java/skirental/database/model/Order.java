package skirental.database.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "ORDERS")
public class Order implements BaseModel {

    public Order(){

    }

    @DatabaseField(generatedId = true)
    private int id;



    @DatabaseField(columnName = "NAME")
    private String name;


    @ForeignCollectionField(columnName = "ITEM_ID", eager = true)
    private ForeignCollection<Items> item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<Items> getItem() {
        return item;
    }

    public void setItem(ForeignCollection<Items> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
