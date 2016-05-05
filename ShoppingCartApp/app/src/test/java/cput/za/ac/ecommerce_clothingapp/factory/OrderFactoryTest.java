package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Order;
import cput.za.ac.ecommerce_clothingapp.factories.OrderFactory;

/**
 * Created by Admin on 2016-05-02.
 */
public class OrderFactoryTest  {

    @Test
    public void testCreateOrder() throws Exception {
        Date oder=new Date();
        Date shipping= new Date();

        Map<String,Date> date = new HashMap<String,Date>();
        Map<String ,Double> myDouble= new HashMap<String ,Double>();




        date.put("orderDate",oder);
        date.put("shippingDate",shipping);


        myDouble.put("discount",60.0);
        myDouble.put("netAmount",300.00);
        myDouble.put("orderAmount",700.00);
        myDouble.put("shippingAmount",350.00);





       Order order = OrderFactory
                .createOrder(myDouble,date);

        Assert.assertEquals((int)60.0,(int)order.getDiscount());
        Assert.assertEquals((int)300.00,(int)order.getNetAmount());
        Assert.assertEquals(oder,order.getOrderDate());
        Assert.assertEquals(shipping,order.getShippingDate());



    }

    @Test
    public void testUpdateOrder() throws Exception {


        Date oder=new Date();
        Date shipping= new Date();

        Map<String,Date> date = new HashMap<String,Date>();
        Map<String ,Double> myDouble= new HashMap<String ,Double>();




        date.put("orderDate",oder);
        date.put("shippingDate",shipping);


        myDouble.put("discount",60.0);
        myDouble.put("netAmount",300.00);
        myDouble.put("orderAmount",700.00);
        myDouble.put("shippingAmount",350.00);





        Order order = OrderFactory
                .createOrder(myDouble,date);


        Order order1= new  Order
                .Builder()
                .copy(order)
                .orderDate(oder)
                .shippingDate(shipping)
                .discount(70.00)
                .netAmount(400.00)
                .orderamount(800.00)
                .shippingAmount(500)
                .build();
        Assert.assertEquals(oder,order.getOrderDate());
        Assert.assertEquals(shipping,order.getShippingDate());

    }


}
