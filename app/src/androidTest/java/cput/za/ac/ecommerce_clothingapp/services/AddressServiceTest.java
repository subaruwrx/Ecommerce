package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class AddressServiceTest extends AndroidTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), AddressService.class);

        intent.putExtra("street","24 Tienkers");
        intent.putExtra("City", "Summer Greens");
        intent.putExtra("Country","South Africa");
        intent.putExtra("postalCode", "7001");
        this.getContext().startService(intent);

    }
}
