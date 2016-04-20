package cput.za.ac.ecommerce_clothingapp.test_factories;

import junit.framework.Assert;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Transport;
import cput.za.ac.ecommerce_clothingapp.factories.Transport_Factory;

/**
 * Created by Admin on 2016-04-20.
 */
public class Transport_Test {
    @Test
    public void testCreateTransport() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("id","BUS001199");
        values.put("available", "yes");
        values.put("location","cape town");
        values.put("root ot travel","joburg via Bloemfontein");
        values.put("transportType","Bus");

        Transport transport = Transport_Factory
                .createTransport(values);

        Assert.assertEquals("BUS001199",transport.getId() );
        Assert.assertEquals("yes",transport.getAvailable());
        Assert.assertEquals("cape town",transport.getLocation());
    }
    @Test
    public void testUpdateTransport() throws Exception {


        Map<String,String> values = new HashMap<String,String>();

        values.put("id","BUS001199");
        values.put("available", "yes");
        values.put("location","cape town");
        values.put("root ot travel","joburg via Bloemfontein");
        values.put("transportType","Bus");

        Transport transport = Transport_Factory
                .createTransport(values);

        Transport transport1= new Transport
                .Builder("BUS001199")
                .availableMethod("yes")
                .rootMethod("joburg via Bloemfontein")
                .locationMethod("Cape town")
                .transportType("Bus")
                .copy(transport)
                .build();
        Assert.assertEquals("BUS001199", transport1.getId());
        Assert.assertEquals("yes",transport1.getAvailable());
        Assert.assertEquals("joburg via Bloemfontein",transport1.getRoot());
        Assert.assertEquals("cape town",transport1.getLocation());

    }



}
