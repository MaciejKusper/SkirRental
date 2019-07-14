package skirental.simpleData;

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
        item.setExternal_id("0006435316");
        item.setServiceDate(new Date(220,11,1));
        item.setAddedDate(new Date());
        Items item2 = new Items();
        item2.setSize("150");
        item2.setType("Snowboard");
        item2.setPrice(12.5);
        item2.setCondition(7.0);
        item2.setDescription("Burton 2016");
        item2.setExternal_id("0006435579");
        item2.setServiceDate(new Date(220,10,1));
        item2.setAddedDate(new Date());
        Items item3 = new Items();
        item3.setSize("180");
        item3.setType("Skis");
        item3.setPrice(11.5);
        item3.setCondition(9.0);
        item3.setDescription("Rossignol 2019");
        item3.setExternal_id("0006435377");
        item3.setServiceDate(new Date(220,8,1));
        item3.setAddedDate(new Date());
        Items item4 = new Items();
        item4.setSize("XL");
        item4.setType("Helmet");
        item4.setPrice(4.5);
        item4.setCondition(9.0);
        item4.setDescription("Oakley 2017");
        item4.setExternal_id("0006435383");
        item4.setServiceDate(new Date());
        item4.setAddedDate(new Date());
        Items item5 = new Items();
        item5.setSize("130");
        item5.setType("Ski poles");
        item5.setPrice(2.0);
        item5.setCondition(5.0);
        item5.setDescription("Rossignol 2017");
        item5.setExternal_id("0006435504");
        item5.setServiceDate(new Date());
        item5.setAddedDate(new Date());
        Items item6 = new Items();
        item6.setSize("140");
        item6.setType("Ski poles");
        item6.setPrice(3.0);
        item6.setCondition(9.0);
        item6.setDescription("Rossignol 2018");
        item6.setExternal_id("0006435412");
        item6.setServiceDate(new Date());
        item6.setAddedDate(new Date());

        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        itemsDao.creatOrUpdate(item);
        itemsDao.creatOrUpdate(item2);
        itemsDao.creatOrUpdate(item3);
        itemsDao.creatOrUpdate(item4);
        itemsDao.creatOrUpdate(item5);
        itemsDao.creatOrUpdate(item6);

        DatabaseManager.closeConnectionSource();

        Customer customer =new Customer();
        customer.setName("Jon");
        customer.setSurname("Snow");
        customer.setExternal_id("0010880780");
        customer.setAddres("Winterfell");
        customer.setAddedDate(new Date());
        Customer customer2 =new Customer();
        customer2.setName("Tyrion");
        customer2.setSurname("Lanister");
        customer2.setExternal_id("0011919858");
        customer2.setAddres("Kings Landing");
        customer2.setAddedDate(new Date());
        Customer customer3 =new Customer();
        customer3.setName("Aria");
        customer3.setSurname("Stark");
        customer3.setExternal_id("0011923201");
        customer3.setAddres("Winterfell");
        customer3.setAddedDate(new Date());
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        customerDao.creatOrUpdate(customer);
        customerDao.creatOrUpdate(customer2);
        customerDao.creatOrUpdate(customer3);
        DatabaseManager.closeConnectionSource();
    }
}
