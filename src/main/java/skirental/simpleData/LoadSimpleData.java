package skirental.simpleData;

import com.j256.ormlite.support.ConnectionSource;
import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.CustomerDao;
import skirental.database.dao.ItemsDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Customer;
import skirental.database.model.Items;

import java.util.Date;

public class LoadSimpleData {

    public static void loadSimpleData() throws ApplicationException {
        Items item = new Items();
        item.setSize("160");
        item.setType("Snowboard");
        item.setPrice(15.0);
        item.setCondition(8.0);
        item.setDescription("Burton 2017");
        item.setExternal_id("1");
        item.setServiceDate(new Date(220,11,1));
        item.setAddedDate(new Date());
        Items item2 = new Items();
        item2.setSize("150");
        item2.setType("Snowboard");
        item2.setPrice(12.5);
        item2.setCondition(7.0);
        item2.setDescription("Burton 2016");
        item2.setExternal_id("2");
        item2.setServiceDate(new Date(220,10,1));
        item2.setAddedDate(new Date());
        Items item3 = new Items();
        item3.setSize("180");
        item3.setType("Skis");
        item3.setPrice(11.5);
        item3.setCondition(9.0);
        item3.setDescription("Rossignol 2019");
        item3.setExternal_id("3");
        item3.setServiceDate(new Date(220,8,1));
        item3.setAddedDate(new Date());
        Items item4 = new Items();
        item4.setSize("XL");
        item4.setType("Helmet");
        item4.setPrice(4.5);
        item4.setCondition(9.0);
        item4.setDescription("Oakley 2017");
        item4.setExternal_id("4");
        item4.setServiceDate(new Date());
        item4.setAddedDate(new Date());
        Items item5 = new Items();
        item5.setSize("130");
        item5.setType("Ski poles");
        item5.setPrice(2.0);
        item5.setCondition(5.0);
        item5.setDescription("Rossignol 2017");
        item5.setExternal_id("5");
        item5.setServiceDate(new Date());
        item5.setAddedDate(new Date());

        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        itemsDao.creatOrUpdate(item);
        itemsDao.creatOrUpdate(item2);
        itemsDao.creatOrUpdate(item3);
        itemsDao.creatOrUpdate(item4);
        itemsDao.creatOrUpdate(item5);
        DatabaseManager.closeConnectionSource();

        Customer customer =new Customer();
        customer.setName("Jon");
        customer.setSurname("Snow");
        customer.setExternal_id("11");
        customer.setAddres("Winterfell");
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        customerDao.creatOrUpdate(customer);

    }
}
