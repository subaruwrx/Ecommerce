package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Brand;

/**
 * Created by Admin on 2016-04-20.
 */
public class Brand_Factory {

    private static  Brand_Factory instance=null;

    private  Brand_Factory(){}

    public static  Brand_Factory getInstance() {
        if (instance == null) {
            instance = new  Brand_Factory();

        }
        return instance;
    }

    public static Brand createBrand( Map<String,String> values) {

        Brand brand = new Brand
                .Builder()
                .brandCode(values.get("Brandcode"))
                .brandName(values.get("BrandName"))
                .build();
        return brand;

    }
}
