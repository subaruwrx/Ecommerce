package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.domain.Division;

/**
 * Created by Admin on 2016-04-20.
 */
public class Division_Factory {
    private static Division_Factory instance=null;

    private Division_Factory(){}

    public static Division_Factory getInstance() {
        if (instance == null) {
            instance = new Division_Factory();

        }
        return instance;
    }

    public static Division createDivision(Address address, Map<String,String> values) {
        Division div= new Division
                .Builder()
                .wareHouse(values.get("wareHouse"))
                .Street(address)
                .producttypewhareH(values.get("productType"))
                .build();
        return div;

    }
}
