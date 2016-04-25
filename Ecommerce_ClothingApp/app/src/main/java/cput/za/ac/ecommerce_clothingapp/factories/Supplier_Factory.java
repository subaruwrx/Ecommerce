package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Supplier;

/**
 * Created by Admin on 2016-04-20.
 */
public class Supplier_Factory {

    private static Supplier_Factory instance=null;

    private Supplier_Factory(){}

    public static Supplier_Factory getInstance() {
        if (instance == null) {
            instance = new Supplier_Factory();

        }
        return instance;
    }
  ///include number of days
    public static Supplier createSupplier(Map<String,String> values) {
        Supplier sup= new Supplier
                .Builder()
                .companyName(values.get("companyName"))
                .supplyingType(values.get("supplyingType"))
                .build();
        return sup;

    }
}
