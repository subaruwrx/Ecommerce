package cput.za.ac.ecommerce_clothingapp.test_factories;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import cput.za.ac.ecommerce_clothingapp.domain.Shopping_Cart;
import cput.za.ac.ecommerce_clothingapp.factories.Shopping_Cart_Factory;

/**
 * Created by Admin on 2016-04-20.
 */
public class Shopping_Cart_Test {

    Date mydate= new Date();
    @Test
    public void testCreateCart()
    {




        Shopping_Cart cart= Shopping_Cart_Factory
                .createShopping_Cart(mydate);



        Assert.assertEquals(mydate,cart.getCreated());

    }



}
