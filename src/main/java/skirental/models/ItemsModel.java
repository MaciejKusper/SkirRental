package skirental.models;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.ItemsDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Items;
import skirental.utils.Converters;

import java.util.Date;
import java.util.List;


public class ItemsModel {

    public void takeItemsFromDB() throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        List<Items> itemsList = itemsDao.queryForAll(Items.class);
        this.itemsFXObservableList.clear();
        itemsList.forEach(items -> {
            ItemsFX itemsFX = new ItemsFX();
            itemsFX.setId(items.getId());
            itemsFX.setAddedDate(Converters.convertToLocalDate(items.getAddedDate()));
            itemsFX.setDescription(items.getDescription());
            itemsFX.setExternal_id(items.getExternal_id());
            itemsFX.setSize(items.getSize());
            itemsFX.setType(items.getType());
            itemsFX.setPrice(items.getPrice());
            itemsFX.setServiceDate(Converters.convertToLocalDate(items.getServiceDate()));
            this.itemsFXObservableList.add(itemsFX);
        });


        DatabaseManager.closeConnectionSource();

    }

    public ObservableList<ItemsFX> getItemsFXObservableList() {
        return itemsFXObservableList;
    }

    public void setItemsFXObservableList(ObservableList<ItemsFX> itemsFXObservableList) {
        this.itemsFXObservableList = itemsFXObservableList;
    }

    private ObservableList<ItemsFX> itemsFXObservableList = FXCollections.observableArrayList();

    public void saveItemToDB(String external_id, String type , Double price, String size, Date serviceDate, String description, Double condition) throws ApplicationException {
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        Items items = new Items();
        items.setExternal_id(external_id);
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
}
