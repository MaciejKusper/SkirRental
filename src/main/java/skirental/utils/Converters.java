package skirental.utils;

import skirental.database.model.Customer;
import skirental.database.model.Items;
import skirental.database.model.Order;
import skirental.models.CustomerFX;
import skirental.models.ItemsFX;
import skirental.models.OrderFX;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Converters {


    public static Double convertToDouble(String str) {
        // Convert String to Double
        try {
            Scanner st = new Scanner(str);
            while (!st.hasNextDouble()) {
                st.next();
            }
            double value = st.nextDouble();
            return value;
        } catch (Exception e) {
            DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorData.price"));
        }

        return null;

    }

    public static Date convertToDate(LocalDate localDate) {
        //Convert from LocalDate to Date
        try {
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        catch (Exception e){
            DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorData.date"));
        }

        return null;
    }

    //Convert from Date to LicalDate
    public static LocalDate convertToLocalDate(Date date){
      try{  return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
      catch (Exception e){
          DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorData.date"));
      }
      return null;
}

public static ItemsFX convertToItemsFX (Items items){
    ItemsFX itemsFX = new ItemsFX();
    itemsFX.setId(items.getId());
    //itemsFX.setOrder_id(convertToOrderFX(items.getOrder()));
    itemsFX.setAddedDate(Converters.convertToLocalDate(items.getAddedDate()));
    itemsFX.setDescription(items.getDescription());
    itemsFX.setExternal_id(items.getExternal_id());
    itemsFX.setSize(items.getSize());
    itemsFX.setType(items.getType());
    itemsFX.setPrice(items.getPrice());
    itemsFX.setServiceDate(Converters.convertToLocalDate(items.getServiceDate()));
    return itemsFX;
}
public static Items convertToItems(ItemsFX itemsFX){
        Items items = new Items();
        items.setId(itemsFX.getId());
    items.setAddedDate(Converters.convertToDate(itemsFX.getAddedDate()));
    items.setDescription(itemsFX.getDescription());
    items.setExternal_id(itemsFX.getExternal_id());
    items.setSize(itemsFX.getSize());
    items.setType(itemsFX.getType());
    items.setPrice(itemsFX.getPrice());
    items.setServiceDate(Converters.convertToDate(itemsFX.getServiceDate()));
    return items;
}

public static CustomerFX ConvertToCustomerFX(Customer customer){

    CustomerFX customerFX = new CustomerFX();
    customerFX.setId(customer.getId());
    customerFX.setName(customer.getName());
    customerFX.setSurname(customer.getSurname());
    customerFX.setAddres(customer.getAddres());
    customerFX.setAddedDate(Converters.convertToLocalDate(customer.getAddedDate()));
    customerFX.setExternal_id(customer.getExternal_id());
    return customerFX;

}

    public static Customer convertToCustomer(CustomerFX customerFX){

        Customer customer = new Customer();
        customer.setId(customerFX.getId());
        customer.setName(customerFX.getName());
        customer.setSurname(customerFX.getSurname());
        customer.setAddres(customerFX.getAddres());
        customer.setAddedDate(Converters.convertToDate(customerFX.getAddedDate()));
        customer.setExternal_id(customerFX.getExternal_id());
        return customer;

    }

public static OrderFX convertToOrderFX(Order order){
    OrderFX orderFX = new OrderFX();
    orderFX.setId(order.getId());
    return  orderFX;
}

public static Order convertToOrder(OrderFX orderFX){
        Order order = new Order();
        order.setId(orderFX.getId());
        return order;
}
}
