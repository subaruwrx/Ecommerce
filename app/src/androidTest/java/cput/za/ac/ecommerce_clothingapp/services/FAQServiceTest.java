package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class FAQServiceTest  extends AndroidTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(),FAQService.class);

        intent.putExtra("question","How many account can one have");
        intent.putExtra("answer","a customer can have one account");

        this.getContext().startService(intent);

    }
}
