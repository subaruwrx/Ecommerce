package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Context;

import cput.za.ac.ecommerce_clothingapp.restapi.resources.FAQResource;

/**
 * Created by Admin on 2016-05-13.
 */
public interface FAQService {
    void addFAQ(Context context, FAQResource  faqResource);

    void deleteFAQ(Context context,FAQResource faqResource);
}
