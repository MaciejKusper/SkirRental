package skirental.models;



import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.ItemsDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Items;

import java.util.Date;


public class ItemsModel {

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
        itemsDao.creatOrUpdate(items);
        DatabaseManager.closeConnectionSource();
    }
}
