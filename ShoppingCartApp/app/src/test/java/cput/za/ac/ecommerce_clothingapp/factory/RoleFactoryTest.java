package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Role;
import cput.za.ac.ecommerce_clothingapp.factories.RoleFactory;

/**
 * Created by Admin on 2016-05-02.
 */
public class RoleFactoryTest {

    @Test
    public void testCreateRole() throws Exception {


        Map<String,String> values = new HashMap<String,String>();

        values.put("role","Admin");
        values.put("description","control");

        Role role = RoleFactory
                .createRole(values);


        Assert.assertEquals( "control",role.getDescription());
        Assert.assertEquals("Admin",role.getRole());

    }

    @Test
    public void testUpdateRole() throws Exception {


        Map<String,String> values = new HashMap<String,String>();

        values.put("role","Admin");
        values.put("description","control");

        Role role = RoleFactory
                .createRole(values);
        Role role1= new Role
                .Builder()
                .copy(role)
                .role("User")
                .description("follow instructions")
                .build();


        Assert.assertEquals("follow instructions",role1.getDescription());
        Assert.assertEquals("User",role1.getRole());

    }
}
