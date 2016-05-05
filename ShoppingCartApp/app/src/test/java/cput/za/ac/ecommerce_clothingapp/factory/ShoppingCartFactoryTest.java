package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import cput.za.ac.ecommerce_clothingapp.domain.ShoppingCart;
import cput.za.ac.ecommerce_clothingapp.factories.ShoppingCartFactory;


/**
 * Created by Admin on 2016-04-20.
 */

public class ShoppingCartFactoryTest {


    @Test
    public void testCreateCart()
    {

        Date mydate= new Date();
        double price=500.00;
        int quantity=2;

       ShoppingCart cart= ShoppingCartFactory
                .createShoppingCart(price,quantity,mydate);



        Assert.assertEquals(mydate,cart.getCreated());
        Assert.assertEquals((int)price,(int)cart.getPrice());
        Assert.assertEquals(quantity,cart.getQauntity());

    }

    @Test
    public void testUpdateCart() throws Exception {
        Date mydate= new Date();
        //sGregorianCalendar



        final double price=600.00;
        final int quantity=3;

        ShoppingCart cart= ShoppingCartFactory
                .createShoppingCart(price,quantity,mydate);

        //mydate.setDate(01/01/2016);

        ShoppingCart cart1= new ShoppingCart
                .Builder()
                .copy(cart)
                .price(400.0)
                .quantity(4)
                .dateCreated(mydate)
                .build();

        Assert.assertEquals(mydate,cart1.getCreated());
        Assert.assertEquals((int)400.0,(int)cart1.getPrice());
        Assert.assertEquals(4,cart1.getQauntity());
        //Assert.assertEquals(4,cart1.getQauntity());



    }





}
