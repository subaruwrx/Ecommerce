package cput.za.ac.ecommerce_clothingapp.factory;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.User;
import cput.za.ac.ecommerce_clothingapp.factories.UserFactory;

/**
 * Created by Admin on 2016-05-02.
 */
public class UserFactoryTest {

    @Test
    public void testCreateUser() throws Exception {
        Map<String, String> values = new HashMap<String, String>();

        values.put("firstName", "Sibabalwe");
        values.put("surName", "Dike");
        values.put("contactNo", "081 894 1030");
        values.put("gender", "male");
        values.put("email", "sibabalwedike@gmail.com");
        values.put("description", "administartion user");


        User user = UserFactory
                .createUser(values);

        Assert.assertEquals("Sibabalwe", user.getFirstName());
        Assert.assertEquals("Dike", user.getSurName());
        Assert.assertEquals("male", user.getGender());
        Assert.assertEquals("sibabalwedike@gmail.com", user.getEmail());

    }


    @Test
    public void testUpdateUser() throws Exception {
        Map<String, String> values = new HashMap<String, String>();

        values.put("firstName", "Sibabalwe");
        values.put("surName", "Dike");
        values.put("contactNo", "081 894 1030");
        values.put("gender", "male");
        values.put("email", "sibabalwedike@gmail.com");
        values.put("description", "administrator");


        User user = UserFactory
                .createUser(values);

        User user1= new User
                .Builder()
                .firstName("Sihle")
                .surName("Ngoniwe")
                .gender("female")
                .contactNo("078 382 2938")
                .email("sihle.ngoniwe@gmail.com")
                .description("user")
                .build();

        Assert.assertEquals("Sihle",user1.getFirstName());
        Assert.assertEquals("Ngoniwe",user1.getSurName());
        Assert.assertEquals("female",user1.getGender());
    }
}