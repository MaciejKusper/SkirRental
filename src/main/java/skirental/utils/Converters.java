package skirental.utils;

import skirental.database.model.Customer;
import skirental.database.model.Items;
import skirental.database.model.Order;
import skirental.models.CustomerFX;
import skirental.models.ItemsFX;
import skirental.models.OrderFX;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public static Integer convertToInteger(String str) {
        // Convert String to integer

            try
            {
                int i = Integer.parseInt(str.trim());
                return i;
            }
            catch (NumberFormatException nfe)
            {
                DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorInteger"));
            }
            return null;
        }


    public static Date convertToDate(LocalDateTime localDateTime) {
        //Convert from LocalDate to Date
        if (localDateTime!=null) {
            try {
                return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            } catch (Exception e) {
                DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorData.date"));
            }
        }
        return null;
    }

    public static Date convertToDatefromLocalDate(LocalDate localDate) {
        //Convert from LocalDate to Date
        if (localDate!=null) {
            try {
                return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            } catch (Exception e) {
                DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorData.date"));
            }
        }
        return null;
    }


    //Convert from Date to LicalDateTime
    public static LocalDateTime convertToLocalDateTime(Date date){
        if (date!=null) {
            try {
                return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            } catch (Exception e) {
                DialogsUtils.errorDialog(FxmlUtils.getResourceBundle().getString("errorData.date"));
            }
        }
      return null;
}

public static ItemsFX convertToItemsFX (Items items){
    ItemsFX itemsFX = new ItemsFX();
    itemsFX.setId(items.getId());
    //itemsFX.setOrder_id(convertToOrderFX(items.getOrder()));
    itemsFX.setAddedDate(Converters.convertToLocalDateTime(items.getAddedDate()));
    itemsFX.setDescription(items.getDescription());
    itemsFX.setExternal_id(items.getExternal_id());
    itemsFX.setSize(items.getSize());
    itemsFX.setType(items.getType());
    itemsFX.setPrice(items.getPrice());
    itemsFX.setServiceDate(Converters.convertToLocalDateTime(items.getServiceDate()));
    itemsFX.setCondition(items.getCondition());
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
    items.setCondition(itemsFX.getCondition());
    return items;
}

public static CustomerFX convertToCustomerFX(Customer customer){

    CustomerFX customerFX = new CustomerFX();
    customerFX.setId(customer.getId());
    customerFX.setName(customer.getName());
    customerFX.setSurname(customer.getSurname());
    customerFX.setAddres(customer.getAddress());
    customerFX.setAddedDate(Converters.convertToLocalDateTime(customer.getAddedDate()));
    customerFX.setExternal_id(customer.getExternal_id());
    return customerFX;

}

    public static Customer convertToCustomer(CustomerFX customerFX){

        Customer customer = new Customer();
        customer.setId(customerFX.getId());
        customer.setName(customerFX.getName());
        customer.setSurname(customerFX.getSurname());
        customer.setAddress(customerFX.getAddres());
        customer.setAddedDate(Converters.convertToDate(customerFX.getAddedDate()));
        customer.setExternal_id(customerFX.getExternal_id());
        return customer;

    }

public static OrderFX convertToOrderFX(Order order){
    OrderFX orderFX = new OrderFX();
    orderFX.setId(order.getId());
    orderFX.setOrderDate(Converters.convertToLocalDateTime(order.getOrderDate()));
    orderFX.setReturnDate(Converters.convertToLocalDateTime(order.getReturnDate()));
    orderFX.setFinalPrice(order.getFinalPrice());
    orderFX.setClientRfid(order.getClientRFID());
    return  orderFX;
}

public static Order convertToOrder(OrderFX orderFX){
        Order order = new Order();
        order.setId(orderFX.getId());
        order.setOrderDate(Converters.convertToDate(orderFX.getOrderDate()));
        order.setReturnDate(Converters.convertToDate(orderFX.getReturnDate()));
        order.setFinalPrice(orderFX.getFinalPrice());
        order.setClientRFID(orderFX.getClientRfid());
        return order;
}
}
