package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class UserServiceTest extends AndroidTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), UserService.class);


        intent.putExtra("firstName", "sibabalwe");
        intent.putExtra("surName", "Dike");
        intent.putExtra("contactNo", "083 567 9001");
        intent.putExtra("gender", "male");
        intent.putExtra("email", "sibabalwe@gmail.com");
        intent.putExtra("description", "Administrator User");
        this.getContext().startService(intent);

    }
}
