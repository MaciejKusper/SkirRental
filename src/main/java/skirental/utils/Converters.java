package skirental.utils;

import skirental.database.model.Items;
import skirental.models.ItemsFX;

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
    itemsFX.setAddedDate(Converters.convertToLocalDate(items.getAddedDate()));
    itemsFX.setDescription(items.getDescription());
    itemsFX.setExternal_id(items.getExternal_id());
    itemsFX.setSize(items.getSize());
    itemsFX.setType(items.getType());
    itemsFX.setPrice(items.getPrice());
    itemsFX.setServiceDate(Converters.convertToLocalDate(items.getServiceDate()));
    return itemsFX;
}
}
