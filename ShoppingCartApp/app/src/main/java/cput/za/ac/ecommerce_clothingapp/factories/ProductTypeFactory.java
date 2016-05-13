package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.ProductType;

/**
 * Created by Admin on 2016-05-03.
 */
public class ProductTypeFactory {
    private static ProductTypeFactory instance=null;

    private ProductTypeFactory(){}

    public static ProductTypeFactory getInstance() {
        if (instance == null) {
            instance = new ProductTypeFactory();

        }
        return instance;
    }

    public static ProductType createProductType(Map<String,String> value){
        return new ProductType.Builder()
                .name(value.get("name"))
                .description(value.get("description"))
                .build();


    }
}
