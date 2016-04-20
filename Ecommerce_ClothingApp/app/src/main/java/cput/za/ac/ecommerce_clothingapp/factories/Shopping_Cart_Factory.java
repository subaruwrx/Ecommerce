package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Date;

import cput.za.ac.ecommerce_clothingapp.domain.Shopping_Cart;

/**
 * Created by Admin on 2016-04-20.
 */
public class Shopping_Cart_Factory {
    private static Shopping_Cart_Factory instance=null;

    private Shopping_Cart_Factory(){}

    public static Shopping_Cart_Factory getInstance() {
        if (instance == null) {
            instance = new Shopping_Cart_Factory();

        }
        return instance;
    }

    public Shopping_Cart createShopping_Cart(Long id, Date created) {

        Shopping_Cart cart= new Shopping_Cart
                .Builder(id)
                .dateCreated(created)
                .build();
        return cart;

    }
}
