package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.RoleResource;

/**
 * Created by Admin on 2016-05-13.
 */
public interface RoleService {

    void addRole(Context context, RoleResource roleResource);

    void deleteRole(Context context, RoleResource roleResource);
}
