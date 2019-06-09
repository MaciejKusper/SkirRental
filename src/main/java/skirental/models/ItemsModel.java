package skirental.models;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.ItemsDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Items;
import skirental.database.model.Order;
import skirental.utils.Converters;

import java.util.Date;
import java.util.List;


public class ItemsModel {

    public void takeItemsFromDB() throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        List<Items> itemsList = itemsDao.queryForAll(Items.class);
        this.itemsFXObservableList.clear();
        itemsList.forEach(items -> {
            ItemsFX itemsFX = Converters.convertToItemsFX(items);
            this.itemsFXObservableList.add(itemsFX);
        });


        DatabaseManager.closeConnectionSource();

    }

    public void takeItemFromDB(Integer Id) throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        Items items = itemsDao.findById(Items.class, Id);

        //this.itemsFXObservableList.clear();
        ItemsFX itemsFX = Converters.convertToItemsFX(items);
        this.itemsFXObservableList.add(itemsFX);
        DatabaseManager.closeConnectionSource();

    }

    public void takeRFIDFromDB(String rfid) throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        List<Items> itemsList  = itemsDao.queryForEq(Items.class,"external_id", rfid);

        //this.itemsFXObservableList.clear();
        itemsList.forEach(items -> {
            ItemsFX itemsFX = Converters.convertToItemsFX(items);
            this.itemsFXObservableList.add(itemsFX);
        });
        DatabaseManager.closeConnectionSource();

    }
    public void takeByOrderIdFromDB(int order_id) throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        List<Items> itemsList  = itemsDao.queryForEq(Items.class,"order_id", order_id);

        //this.itemsFXObservableList.clear();
        itemsList.forEach(items -> {
            ItemsFX itemsFX = Converters.convertToItemsFX(items);
            this.itemsFXObservableList.add(itemsFX);
            this.customerId.setValue(items.getCustomer().getId());
            //System.out.println(customerId);
        });
        DatabaseManager.closeConnectionSource();

    }

    public void saveItemToDB(String external_id, Order order, String type , Double price, String size, Date serviceDate, String description, Double condition) throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        Items items = new Items();
        items.setExternal_id(external_id);
        items.setOrder(order);
        items.setType(type);
        items.setPrice(price);
        items.setSize(size);
        items.setServiceDate(serviceDate);
        items.setDescription(description);
        items.setCondition(condition);
        items.setAddedDate(new Date());
        itemsDao.creatOrUpdate(items);
        DatabaseManager.closeConnectionSource();
        this.takeItemsFromDB();
    }

    public  void orderItems(ObservableList<ItemsFX> itemsFXObservableList , ObjectProperty<OrderFX> orderFXObjectProperty, ObjectProperty<CustomerFX> customerFXObjectProperty){
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());

        itemsFXObservableList.forEach(itemsFX->{
                Items items=  Converters.convertToItems(itemsFX);
                items.setOrder(Converters.convertToOrder(orderFXObjectProperty.get()));
                items.setCustomer(Converters.convertToCustomer(customerFXObjectProperty.get()));
                    try {
                        itemsDao.creatOrUpdate(items);
                    } catch (ApplicationException e) {
                        e.printStackTrace();
                    }
                    finally {
                        DatabaseManager.closeConnectionSource();
                    }
                }
                );

    }

    private ObservableList<ItemsFX> itemsFXObservableList = FXCollections.observableArrayList();

    public ObservableList<ItemsFX> getItemsFXObservableList() {
        return itemsFXObservableList;
    }

    public void setItemsFXObservableList(ObservableList<ItemsFX> itemsFXObservableList) {
        this.itemsFXObservableList = itemsFXObservableList;
    }
    private IntegerProperty customerId = new SimpleIntegerProperty();

    public int getCustomerId() {
        return customerId.get();
    }

    public IntegerProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }
}
