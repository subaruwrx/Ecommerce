package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.OffersResource;

/**
 * Created by Admin on 2016-05-13.
 */
public interface OffersService {
    void addOffers(Context context, OffersResource offersResource );

    void deleteOffers(Context context,OffersResource  offersResource );
}
