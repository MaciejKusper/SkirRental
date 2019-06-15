package skirental.database.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "ORDERS")
public class Order implements BaseModel {

    public Order(){

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "ORDER_DATE")
    private Date orderDate;

    @DatabaseField(columnName = "RETURN_DATE")
    private Date returnDate;

    @DatabaseField(columnName = "FINAL_PRICE")
    private int finalPrice;

    @DatabaseField(columnName = "CLIENT_RFID")
    private String ClientRFID;


    @ForeignCollectionField()
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getClientRFID() {
        return ClientRFID;
    }

    public void setClientRFID(String clientRFID) {
        ClientRFID = clientRFID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
