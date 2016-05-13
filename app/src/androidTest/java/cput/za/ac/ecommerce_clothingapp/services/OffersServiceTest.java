package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class OffersServiceTest  extends AndroidTestCase {


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(),OffersService.class);

        intent.putExtra("offerStartDate","25-05-2016");
        intent.putExtra("offerEndDate","26-05-2016");
        intent.putExtra(" offerPrice",800.00);
        intent.putExtra("description","60% for all sneakers");

        this.getContext().startService(intent);

    }
}
