package skirental.models;

import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.CustomerDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Customer;
import skirental.database.model.Items;

public class ItemsModel {

    public void saveItemToDB (String external_id, String type, Double price, String size, String descryption) throws ApplicationException {
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        Items items = new Items();
        items.setExternal_id(external_id)
        items.setType(type);
        items.setPrice(price);
        items.setSize(size);
        items.setDescription(descryption);
        customerDao.creatOrUpdate(items);
        DatabaseManager.closeConnectionSource();
    }
}
