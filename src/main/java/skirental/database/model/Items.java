package skirental.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


import java.util.Date;

@DatabaseTable(tableName = "ITEMS")
public class Items implements BaseModel {
    public Items() {
    }

    public static final String ORDER_ID = "ORDER_ID";

    @DatabaseField(generatedId = true, unique =true)
    private int id;

    @DatabaseField(columnName = ORDER_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Order order;
    @DatabaseField(columnName = "CUSTOMER_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Customer customer;
    @DatabaseField(columnName = "EXTERNAL_ID", canBeNull = false, unique = true)
    private String external_id;

    @DatabaseField(columnName = "TYPE")
    private String type;

    @DatabaseField(columnName = "PRICE" , canBeNull = false)
    private Double price;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @DatabaseField(columnName = "SIZE")
    private String size;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    @DatabaseField(columnName = "SERVICE_DATE", canBeNull = false)
    private Date serviceDate;

    @DatabaseField(columnName = "DESCRIPTION")
    private String description;

    @DatabaseField(columnName = "CONDITION", width = 1)
    private Double condition;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Double getCondition() {
        return condition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCondition(Double condition) {
        this.condition = condition;
    }
}



