package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.domain.Customer;

/**
 * Created by Admin on 2016-04-19.
 */
public class Customer_Factory {

    private static  Customer_Factory instance=null;

    private Customer_Factory(){}

    public static Customer_Factory getInstance() {
        if (instance == null) {
            instance = new Customer_Factory();

        }
        return instance;
    }

    public static Customer createCustomer( Map<String,String> values, Address address) {

        Customer cust = new Customer.Builder()
                .custNumber(values.get("customerNumber"))
                .custName(values.get("custName"))
                .custSurname(values.get("custSurname"))
                .Address(address)
                .build();
        return cust;

    }
}
