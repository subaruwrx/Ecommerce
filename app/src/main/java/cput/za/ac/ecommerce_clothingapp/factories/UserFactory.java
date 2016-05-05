package cput.za.ac.ecommerce_clothingapp.factories;


import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.User;

/**
 * Created by Admin on 2016-05-02.
 */
public class UserFactory  {
    private static UserFactory instance=null;

    private UserFactory(){}

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();

        }
        return instance;
    }

    public static User createUser(Map<String,String> values)
    {
        User user= new User
                .Builder()
                .firstName(values.get("firstName"))
                .surName(values.get("surName"))
                .description(values.get("description"))
                .email(values.get("email"))
                .gender(values.get("gender"))
                .contactNo(values.get("contactNo"))
                .build();
        return user;
    }
}
