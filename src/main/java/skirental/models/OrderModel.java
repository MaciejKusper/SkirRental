package skirental.models;

import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.OrdersDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Order;

public class OrderModel {

public void saveOrderToDatabase(String name ) throws ApplicationException {

    OrdersDao orderDao = new OrdersDao(DatabaseManager.getConnectionSource());
   Order order = new Order();
    order.setName(name);
    orderDao.creatOrUpdate(order);
   DatabaseManager.closeConnectionSource();
}


}
