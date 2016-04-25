package cput.za.ac.ecommerce_clothingapp.test_factories;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Brand;
import cput.za.ac.ecommerce_clothingapp.factories.Brand_Factory;

/**
 * Created by Admin on 2016-04-20.
 */
public class Brand_Test {

    @Test
    public void testCreateBrand() throws Exception {

        final String name="Nike";
        final String code="Nikw101";
        Map<String,String> values = new HashMap<String,String>();

        values.put("brandName",name);
        values.put("brandCode", code);



        Brand brand = Brand_Factory
                .createBrand(values);

       Assert.assertEquals(name,brand.getBrandName() );
       Assert.assertEquals(code,brand.getBrandCode());

    }
    @Test
    public void testUpdateBrand() throws Exception {
        final String name="Nike";
        final String code="Nikw101";
        Map<String,String> values = new HashMap<String,String>();

        values.put("brandName","Addidas");
        values.put("brandCode", "Adc101");



        Brand brand= Brand_Factory
                .createBrand(values);

        Brand brand1= new Brand
                .Builder()
                .copy(brand)
                .brandCode(code)
                .brandName(name)
                .build();



        Assert.assertEquals(name,brand1.getBrandName());
        Assert.assertEquals(code,brand1.getBrandCode());

    }


}
