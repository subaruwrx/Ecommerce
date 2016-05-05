package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Date;

import cput.za.ac.ecommerce_clothingapp.domain.ShoppingCart;

/**
 * Created by Admin on 2016-04-14.
 */
public class ShoppingCartFactory {

    private static ShoppingCartFactory instance=null;

    private ShoppingCartFactory(){}

    public static ShoppingCartFactory getInstance() {
        if (instance == null) {
            instance = new ShoppingCartFactory();

        }
        return instance;
    }

    public static ShoppingCart createShoppingCart(double price, int quantity, Date created) {

        ShoppingCart cart= new ShoppingCart
                .Builder()
                .quantity(quantity)
                .price(price)
                .dateCreated(created)
                .build();
        return cart;

    }
}
