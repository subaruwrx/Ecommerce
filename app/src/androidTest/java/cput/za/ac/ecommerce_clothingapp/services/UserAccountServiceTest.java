package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class UserAccountServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), UserAccountService.class);


        intent.putExtra("userName", "S212039210");
        intent.putExtra("password", "dik1234");
        intent.putExtra("description", "Admin");
        intent.putExtra("hintQuestion", "whats your pets name?");
        intent.putExtra("answer", "Alex");
        this.getContext().startService(intent);

    }
}
