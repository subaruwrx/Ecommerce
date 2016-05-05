package cput.za.ac.ecommerce_clothingapp.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.factories.AddressFactory;


/**
 * Created by Admin on 2016-04-15.
 */
public class AddressFactoryTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateAddress() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("city","cape town");
        values.put("country", "South Africa");
        values.put("street","24 tienkers road");
        values.put("zipCode","8001");


        Address adress = AddressFactory
                .createAddress(values);

        Assert.assertEquals("cape town",adress.getCity() );
        Assert.assertEquals("South Africa",adress.getCountry());
        Assert.assertEquals("24 tienkers road",adress.getStreet());
        Assert.assertEquals("8001",adress.getZipCode());
    }
    @Test
    public void testUpdateAddress() throws Exception {


        Map<String,String> values = new HashMap<String,String>();

        values.put("city","cape town");
        values.put("country", "South Africa");
        values.put("street","24 tienkers road");
        values.put("zipCode","8001");


        Address adress = AddressFactory
                .createAddress(values);

       Address address1= new Address
                .Builder()
                .copy(adress)
                .city("summer greens")
                .country("South Africa")
                .street("14 caledon street")
                .zipCode("8002")

                .build();
        Assert.assertEquals("summer greens", address1.getCity());
        Assert.assertEquals("South Africa",address1.getCountry());
        Assert.assertEquals("14 caledon street",address1.getStreet());
        Assert.assertEquals("8002",address1.getZipCode());

    }


}
