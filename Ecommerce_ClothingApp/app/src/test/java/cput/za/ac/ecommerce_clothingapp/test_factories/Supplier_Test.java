package cput.za.ac.ecommerce_clothingapp.test_factories;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Sale;
import cput.za.ac.ecommerce_clothingapp.domain.Supplier;
import cput.za.ac.ecommerce_clothingapp.factories.Supplier_Factory;

/**
 * Created by Admin on 2016-04-20.
 */
public class Supplier_Test {

    @Test
    public void testCreateSupplier() throws Exception {
        final String name="Nik0982";
        final String type="shoes";
        Map<String,String> values = new HashMap<>();


        values.put("companyName",name);
        values.put("supplyingType", type);



        Supplier supplier = Supplier_Factory
                .createSupplier(values);

        Assert.assertEquals(name,supplier.getCompanyName() );
        Assert.assertEquals(type,supplier.getSupplyingType());

    }


    @Test
    public void testUpdateSale() throws Exception {


        final String name="Addidas";
        final String type="shoes";
        Map<String,String> values = new HashMap<>();


        values.put("companyName","Nike");
        values.put("supplyingType", "T-shirts");



        Supplier supplier = Supplier_Factory
                .createSupplier(values);



        Supplier supplier1= new Supplier
                .Builder()
                .copy(supplier)
                .companyName(name)
                .supplyingType(type)
                .build();
        Assert.assertEquals(name,supplier1.getCompanyName());
        Assert.assertEquals(type,supplier1.getSupplyingType());


    }




}
