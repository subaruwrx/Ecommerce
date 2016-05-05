package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.UserAccount;
import cput.za.ac.ecommerce_clothingapp.factories.UserAccountFactory;

/**
 * Created by Admin on 2016-05-02.
 */
public class UserAccountFactoryTest {

    @Test
    public void testCreateAccountUser() throws Exception {
        Map<String, String> values = new HashMap<String, String>();

        values.put("userName", "S212039210");
        values.put("password", "dik1234");
        values.put("description", "Admin");
        values.put("hintQuestion", "whats your pets name?");
        values.put("answer", "Alex");



        UserAccount account = UserAccountFactory
                .createUserAccount(values);

        Assert.assertEquals("S212039210",account.getUserName() );
        Assert.assertEquals("dik1234", account.getPassword());
        Assert.assertEquals("Admin",account.getDescription());
        Assert.assertEquals("whats your pets name?",account.getHintQuestion());
        Assert.assertEquals("Alex",account.getAnswer());

    }

    @Test
    public void testUpdateAccountUser() throws Exception {
        Map<String, String> values = new HashMap<String, String>();

        values.put("userName", "S212039210");
        values.put("password", "dik1234");
        values.put("description", "Admin");
        values.put("hintQuestion", "whats your pets name?");
        values.put("answer", "Alex");


        UserAccount account = UserAccountFactory
                .createUserAccount(values);

        UserAccount account1 = new UserAccount
                .Builder()
                .copy(account)
                .userName("S212128120")
                .password("sam4321")
                .description("User")
                .hintQuestion("whats your favourite car?")
                .answer("Maserati")
                .build();

        Assert.assertEquals("S212128120",account1.getUserName() );
        Assert.assertEquals("sam4321", account1.getPassword());
        Assert.assertEquals("User",account1.getDescription());
        Assert.assertEquals("whats your favourite car?",account1.getHintQuestion());
        Assert.assertEquals("Maserati",account1.getAnswer());

    }

}
