package skirental.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "ITEMS")
public class Items implements BaseModel {
    public Items() {
    }

    public static final String ORDER_ID = "ORDER_ID";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = ORDER_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Order order_id;
    @DatabaseField(columnName = "CUSTOMER_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Customer customer_id;
    @DatabaseField(columnName = "EXTERNAL_ID", canBeNull = false)
    private String external_id;

    @DatabaseField(columnName = "TYPE", canBeNull = false)
    private String type;

    @DatabaseField(columnName = "PRICE", canBeNull = false)
    private Double price;

    @DatabaseField(columnName = "SIZE", canBeNull = false)
    private String size;

    //@DatabaseField(columnName = "ADDED_DATE")
   // private Date addedDate;

    @DatabaseField(columnName = "DESCRIPTION")
    private String description;

    @DatabaseField(columnName = "INSTOCK", defaultValue = "1")
    private Boolean inStock;

    @DatabaseField(columnName = "CONDITION", width = 1)
    private int condition;

    //@DatabaseField(columnName = "SERVICE_DATE")
  //  private Date serviceDate;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    /*public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
*/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
/*
    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
*/
    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", external_id='" + external_id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
              //  ", addedDate=" + addedDate +
                ", description='" + description + '\'' +
                ", inStock=" + inStock +
                ", condition=" + condition +
              //  ", serviceDate=" + serviceDate +
                '}';
    }
}
