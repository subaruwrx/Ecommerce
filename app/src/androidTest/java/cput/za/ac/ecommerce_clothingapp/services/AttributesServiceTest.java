package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class AttributesServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), AttributesService.class);


        intent.putExtra("attributeName","color");
        intent.putExtra("attributeValue","red");
        intent.putExtra("description","by jordan nike sneakers");
        this.getContext().startService(intent);

    }
}
