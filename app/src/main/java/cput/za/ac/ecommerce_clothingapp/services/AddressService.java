package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.AddressResource;

/**
 * Created by Admin on 2016-05-08.
 */
public interface AddressService  {
    void addPersonAddress(Context context, AddressResource addressResource);

    void deleteAddress(Context context, AddressResource addressResource);


}
