package cput.za.ac.ecommerce_clothingapp.factories;


import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.OrderStatus;

/**
 * Created by Admin on 2016-05-02.
 */
public class OrderStatusFactory {
    private static  OrderStatusFactory instance=null;

    private  OrderStatusFactory(){}

    public static  OrderStatusFactory getInstance() {
        if (instance == null) {
            instance = new  OrderStatusFactory();

        }
        return instance;
    }

    public static OrderStatus createOrderStatus(Map<String,String> values) {

        OrderStatus status=new OrderStatus
                .Builder()
                .name(values.get("name"))
                .description(values.get("description"))
                .build();


                return status;
    }
}
