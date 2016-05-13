package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.UserAccountResource;

/**
 * Created by Admin on 2016-05-08.
 */
public interface UserAccountService  {
    void addUserAccount(Context context,UserAccountResource userAccountResourceserAccount);

    void deleteUserAccount(Context context,UserAccountResource userAccountResourceserAccount);
}

