package cput.za.ac.ecommerce_clothingapp.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Admin on 2016-05-13.
 */
public class RoleServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), RoleService.class);

        intent.putExtra("role","Admin");
        intent.putExtra("description","control");
        this.getContext().startService(intent);

    }
}
