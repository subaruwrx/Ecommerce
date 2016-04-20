package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Date;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Account;
import cput.za.ac.ecommerce_clothingapp.domain.Address;

/**
 * Created by Admin on 2016-04-19.
 */
public class Account_Factory {


    private static Account_Factory instance=null;

    private Account_Factory(){}

    public static Account_Factory getInstance() {
        if (instance == null) {
            instance = new Account_Factory();

        }
        return instance;
    }
    public static Account createAccount( Address address, Map<String, String> values, Date date, boolean is_closed)
    {


        Account account =  new Account
                .Builder()
                .accountNumber(values.get("accountNumber"))
                .addressAccount(address)
                .open(date)
                .is_Closed(is_closed)
                .closed(date)
                .build();

        return account;
    }
}
