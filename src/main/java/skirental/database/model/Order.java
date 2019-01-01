package skirental.database.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

public class Order {

    @DatabaseField(generatedId = true)
    private int id;


    @ForeignCollectionField(eager = true)
    private ForeignCollection<Items> item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
