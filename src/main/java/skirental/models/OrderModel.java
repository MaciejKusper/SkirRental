package skirental.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.omg.CORBA.portable.ApplicationException;
import skirental.database.dao.OrdersDao;
import skirental.database.dbUtils.DatabaseManager;
import skirental.database.model.Order;
import skirental.utils.Converters;

import java.util.Date;
import java.util.List;

public class OrderModel {



    public ObjectProperty<OrderFX>  orderFXObjectProperty = new SimpleObjectProperty<>();
    public IntegerProperty orderIdProperty = new SimpleIntegerProperty();
    public ObjectProperty<OrderFX>  returnOrderFXObjectProperty = new SimpleObjectProperty<>();
    public IntegerProperty returnOrderIdProperty = new SimpleIntegerProperty();


public void saveOrderToDatabase() throws ApplicationException {
    OrdersDao orderDao = new OrdersDao(DatabaseManager.getConnectionSource());
   Order order = new Order();
   order.setOrderDate(new Date(System.currentTimeMillis()));
   orderDao.creatOrUpdate(order);
   DatabaseManager.closeConnectionSource();
}

public void takeLastOrderFromDatabase() throws ApplicationException{
    OrdersDao orderDao = new OrdersDao(DatabaseManager.getConnectionSource());
    List<Order> orderList = orderDao.queryForAll(Order.class);
    Order order = orderList.get(orderList.size()-1);
    OrderFX orderFX = Converters.convertToOrderFX(order);
    this.orderIdProperty.setValue(order.getId());
    this.orderFXObjectProperty.set(orderFX);
    DatabaseManager.closeConnectionSource();
}

    public void takeOrderByID(int id) throws ApplicationException {
        OrdersDao orderDao = new OrdersDao(DatabaseManager.getConnectionSource());
        Order order = orderDao.findById(Order.class, id);
        if(order!=null) {
            OrderFX orderFX = Converters.convertToOrderFX(order);
            returnOrderIdProperty.setValue(order.getId());
            returnOrderFXObjectProperty.set(orderFX);
        }
        DatabaseManager.closeConnectionSource();
    }

    public void returnOrder(ObjectProperty<OrderFX>  retOrderFXObjectProperty,Integer finalPrice,String clientRfid){
    OrdersDao ordersDao = new OrdersDao(DatabaseManager.getConnectionSource());
    Order order = Converters.convertToOrder(retOrderFXObjectProperty.get());
    order.setReturnDate(new Date(System.currentTimeMillis()));
    order.setFinalPrice(finalPrice);
    order.setClientRFID(clientRfid);
        try {
            ordersDao.creatOrUpdate(order);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        finally {
            DatabaseManager.closeConnectionSource();
        }
    }

    public OrderFX getOrderFXObjectProperty() {
        return orderFXObjectProperty.get();
    }

    public ObjectProperty<OrderFX> orderFXObjectPropertyProperty() {
        return orderFXObjectProperty;
    }

    public void setOrderFXObjectProperty(OrderFX orderFXObjectProperty) {
        this.orderFXObjectProperty.set(orderFXObjectProperty);
    }

    public int getOrderIdProperty() {
        return orderIdProperty.get();
    }

    public IntegerProperty orderIdPropertyProperty() {
        return orderIdProperty;
    }

    public void setOrderIdProperty(int orderIdProperty) {
        this.orderIdProperty.set(orderIdProperty);
    }

}
