package cput.za.ac.ecommerce_clothingapp.factories;


import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Brand;

/**
 * Created by Admin on 2016-04-14.
 */
public class BrandFactory {

    private static BrandFactory instance=null;

    private BrandFactory(){}

    public static BrandFactory getInstance() {
        if (instance == null) {
            instance = new BrandFactory();

        }
        return instance;
    }

    public static Brand createBrand(Map<String,String>values) {

        Brand brand = new Brand
                .Builder()
                .brandName(values.get("BrandName"))
                .build();
        return brand;

    }
}
