package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Product;
import cput.za.ac.ecommerce_clothingapp.factories.ProductFactory;

/**
 * Created by Admin on 2016-04-29.
 */
public class ProductFactoryTest {

    @Test
    public void testCreateProduct() throws Exception {


        final int quantity=3;
        Map<String,String> values = new HashMap<String,String>();
        Map<String ,Double> myDouble= new HashMap<String ,Double>();
        //Map<String, byte[]> image= new HashMap<String, byte[]>();



        values.put("productName","Nike");
        values.put("productType","Sneaker");
        values.put("description","by jordan");

        myDouble.put("originalPrice",600.0);
        myDouble.put("salePrice",300.00);

        //image.put("image",);




        Product product = ProductFactory
                .createProduct(myDouble,values,quantity);


        Assert.assertEquals("Nike",product.getProdName());
        Assert.assertEquals("Sneaker",product.getProdtype());
        Assert.assertEquals("by jordan",product.getDescription());
        Assert.assertEquals((int)600.0,(int)product.getOriginalPrice());
        Assert.assertEquals((int)300.00,(int)product.getSalePrice());

    }
    @Test
    public void testUpdateProduct() throws Exception {


        final int quantity=3;
        Map<String,String> values = new HashMap<String,String>();
        Map<String ,Double> myDouble= new HashMap<String ,Double>();
        //Map<String, byte[]> image= new HashMap<String, byte[]>();



        values.put("productName","Nike");
        values.put("productType","Sneaker");
        values.put("description","by jordan");

        myDouble.put("originalPrice",600.00);
        myDouble.put("salePrice",300.00);




        Product product = ProductFactory
                .createProduct(myDouble,values,quantity);


        Product product1= new Product
                .Builder()
                .copy(product)
                .productName("Addidas")
                .productType("Hoody")
                .description("by Kanye west")
                .originalPrice(300.00)
                .salePrice((int)200.00)
                .build();
        Assert.assertEquals("Addidas",product1.getProdName()) ;
        Assert.assertEquals("Hoody",product1.getProdtype());
        Assert.assertEquals("by Kanye west",product1.getDescription());
        Assert.assertEquals((int)300.00,(int)product1.getOriginalPrice());
        Assert.assertEquals((int)200.00,(int)product1.getSalePrice());

    }


}
