package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.AttributesResource;

/**
 * Created by Admin on 2016-05-13.
 */
public interface AttributesService {

    void addAttributes(Context context, AttributesResource attributesResource);

    void deleteAttributes(Context context, AttributesResource attributesResource);
}
