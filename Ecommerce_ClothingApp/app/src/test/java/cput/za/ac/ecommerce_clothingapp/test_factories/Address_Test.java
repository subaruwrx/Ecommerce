package cput.za.ac.ecommerce_clothingapp.test_factories;

import junit.framework.Assert;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.factories.Address_Factory;

/**
 * Created by Admin on 2016-04-19.
 */
public class Address_Test {
    @Test
    public void testCreateAddress() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("city","cape town");
        values.put("country", "South Africa");
        values.put("street","24 tienkers road");


        Address adress = Address_Factory
                .createAddress(values);

        Assert.assertEquals("cape town",adress.getCity() );
        Assert.assertEquals("South Africa",adress.getCountry());
        Assert.assertEquals("24 tienkers road",adress.getStreet());
    }
    @Test
    public void testUpdateAddress() throws Exception {

        final String country="South america";
        Map<String,String> values = new HashMap<String,String>();

        values.put("city","cape town");
        values.put("country", "South Africa");
        values.put("street","24 tienkers road");


        Address adress = Address_Factory
                .createAddress(values);

        Address address1= new Address
                .Builder("joburg")
                 .copy(adress)
                .country(country)
                .Street("14 caledon street")
                .build();



        Assert.assertEquals(country,address1.getCountry());
        Assert.assertEquals("14 caledon street",address1.getStreet());

    }


}
