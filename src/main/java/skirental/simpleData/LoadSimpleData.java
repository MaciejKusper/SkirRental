package skirental.simpleData;

import com.j256.ormlite.support.ConnectionSource;
import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.ItemsDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Items;

import java.util.Date;

public class LoadSimpleData {

    public static void loadSimpleData() throws ApplicationException {
        Items item = new Items();
        item.setSize("180");
        item.setType("Snowboard");
        item.setPrice(5.5);
        item.setCondition(5.0);
        item.setDescription("Całkiem fajna deska");
        item.setExternal_id("KKSN");
        item.setServiceDate(new Date());
        item.setAddedDate(new Date());
        ItemsDao itemsDao = new ItemsDao(DatabaseManager.getConnectionSource());
        itemsDao.creatOrUpdate(item);
        DatabaseManager.closeConnectionSource();
    }
}
