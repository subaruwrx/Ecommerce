package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.OrderDetails;
import cput.za.ac.ecommerce_clothingapp.factories.OrderDetailsFactory;

/**
 * Created by Admin on 2016-05-02.
 */
public class OrderDetailsFactoryTest {
    @Test
    public void testcreateOrderDetails() throws Exception {

       int num=5;
        Map<String ,Double> values= new HashMap<String ,Double>();


        values.put("productPrice",200.40);
        values.put("discount",50.20);



        OrderDetails datails = OrderDetailsFactory
                .createOrderDetails(values,num);

        Assert.assertEquals((int)200.40,(int)datails.getProductPrice());
         Assert.assertEquals(num,datails.getQuantity());



    }



    @Test
    public void testUpdateOrderDetails() throws  Exception{

        final int num=5;
        Map<String ,Double> values= new HashMap<String ,Double>();


        values.put("productPrice",200.40);
        values.put("discount",50.20);



        OrderDetails datails = OrderDetailsFactory
                .createOrderDetails(values,6);

        OrderDetails details1= new OrderDetails
                .Builder()
                .copy(datails)
                .productPrice(300.00)
                .discount(20.00)
                .quantity(num)
                .build();

        Assert.assertEquals((int)300.00,(int)details1.getProductPrice());
        Assert.assertEquals((int)20.00,(int)details1.getDiscount());
        Assert.assertEquals(num,details1.getQuantity());


    }
}
