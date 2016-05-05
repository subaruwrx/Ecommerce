package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Attributes;

/**
 * Created by Admin on 2016-05-03.
 */
public class AttributesFactory {

    private static AttributesFactory instance=null;

    private AttributesFactory(){}

    public static AttributesFactory getInstance() {
        if (instance == null) {
            instance = new AttributesFactory();

        }
        return instance;
    }




    public static Attributes createAttributes(Map<String,String> values) {
        Attributes attributes = new Attributes
                .Builder()
                .attributeName(values.get("attributeName"))
                .attributeValue(values.get("attributeValue"))
                .description(values.get("description"))
                .build();
        return attributes;

    }
}
