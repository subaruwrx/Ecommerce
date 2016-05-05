package cput.za.ac.ecommerce_clothingapp.factories;


import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.OrderDetails;

/**
 * Created by Admin on 2016-05-02.
 */
public class OrderDetailsFactory {

    private static OrderDetailsFactory instance=null;

    private OrderDetailsFactory(){}

    public static OrderDetailsFactory getInstance() {
        if (instance == null) {
            instance = new OrderDetailsFactory();

        }
        return instance;
    }

    public static OrderDetails createOrderDetails(Map<String,Double> values, int quantity) {

        OrderDetails details = new OrderDetails
                .Builder()
                .productPrice(values.get("productPrice"))
                .discount(values.get("discount"))
                .quantity(quantity)
                .build();
        return details;

    }
}
