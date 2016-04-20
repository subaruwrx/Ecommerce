package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Product;

/**
 * Created by Admin on 2016-04-20.
 */
public class Product_Factory {

    private static  Product_Factory instance=null;

    private Product_Factory(){}

    public static Product_Factory getInstance() {
        if (instance == null) {
            instance = new Product_Factory();

        }
        return instance;
    }

    public static Product createProduct( Map<String,String> values,int quan) {

        Product product = new Product
                .Builder()
                .productMethod(values.get("productsize"))
                .productName(values.get("productName"))
                .productQuantity(quan)
                .productType(values.get("productType"))

                .build();
        return product;

    }
}
