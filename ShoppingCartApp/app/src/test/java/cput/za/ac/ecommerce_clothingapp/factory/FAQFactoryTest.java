package cput.za.ac.ecommerce_clothingapp.factory;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.FAQ;
import cput.za.ac.ecommerce_clothingapp.factories.FAQFactory;


/**
 * Created by Admin on 2016-05-03.
 */
public class FAQFactoryTest {
    @Test
    public void testCreateFAQ() throws Exception {



        Map<String,String> values = new HashMap<String,String>();

        values.put("question","How many account can one have");
        values.put("answer","a customer can have one account");



        FAQ faq = FAQFactory
                .createFAQ(values);


        Assert.assertEquals( "How many account can one have",faq.getQuestion());
        Assert.assertEquals("a customer can have one account",faq.getAnswer());

    }

    @Test
    public void testUpdateFAQ() throws Exception {



        Map<String,String> values = new HashMap<String,String>();

        values.put("question","How many account can one have");
        values.put("answer","a customer can have one account");



        FAQ faq = FAQFactory
                .createFAQ(values);
        FAQ faq1 =new FAQ
                .Builder()
                .copy(faq)
                .question("Is the system secure")
                .answer("yes")
                .build();


        Assert.assertEquals( "Is the system secure",faq1.getQuestion());
        Assert.assertEquals("yes",faq1.getAnswer());



    }


}
