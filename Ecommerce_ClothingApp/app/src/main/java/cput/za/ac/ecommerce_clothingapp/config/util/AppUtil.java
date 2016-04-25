package cput.za.ac.ecommerce_clothingapp.config.util;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Admin on 2016-04-23.
 */
public class AppUtil {



    public static  Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date value = null;
        try {
            value = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getBaserURI(){
        return "localhost";
    }

}
