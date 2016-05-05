package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Date;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Order;

/**
 * Created by Admin on 2016-04-14.
 */
public class OrderFactory {

    private static OrderFactory instance=null;

    private OrderFactory(){}

    public static OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();

        }
        return instance;
    }

    public static Order createOrder(Map<String,Double> values, Map<String,Date> date) {

        Order order = new Order
                .Builder()
                .orderDate(date.get("orderDate"))
                .shippingDate(date.get("shippingDate"))
                .discount(values.get("discount"))
                .netAmount(values.get("netAmount"))
                .orderamount(values.get("orderAmount"))
                .shippingAmount(values.get("shippingAmount"))
                .build();
        return order;

    }
}
