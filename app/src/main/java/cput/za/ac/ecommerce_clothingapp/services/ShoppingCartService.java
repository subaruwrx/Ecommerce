package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.ShoppingCartResource;

/**
 * Created by Admin on 2016-05-13.
 */
public interface ShoppingCartService {
    void addCart(Context context,ShoppingCartResource shoppingCartResource);

    void deleteCart(Context context,ShoppingCartResource shoppingCartResource);
}
