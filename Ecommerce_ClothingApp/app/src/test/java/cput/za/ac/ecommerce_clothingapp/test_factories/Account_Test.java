package cput.za.ac.ecommerce_clothingapp.test_factories;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Account;
import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.factories.Account_Factory;
import cput.za.ac.ecommerce_clothingapp.factories.Address_Factory;

/**
 * Created by Admin on 2016-04-19.
 */


public class Account_Test {

    Date mydate= new Date();

    @Test
    public void testCreateAccount() throws Exception {

        String closed=true;

        Map<String, String> values = new HashMap<>();

        Map<String,String> values1= new HashMap<>();

        //address
        values1.put("city","cape town");
        values1.put("country", "South Africa");
        values1.put("street","24 tienkers road");


        Address address = Address_Factory
                .createAddress(values1);

        //Account
        values.put("accountNumber", "1000093090");




        Account account = Account_Factory
                .createAccount(address,values,mydate,closed);


        Assert.assertEquals(mydate,account.getClosed());
        //Assert.assertFalse(closed,account.is_closed());


        Assert.assertEquals("cape town",address.getCity());
        Assert.assertEquals("South Africa",address.getCountry());
        Assert.assertEquals("24 tienkers road",address.getStreet());
    }
}
