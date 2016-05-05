package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Rating;
import cput.za.ac.ecommerce_clothingapp.factories.RatingFactory;

/**
 * Created by Admin on 2016-04-30.
 */
public class RatingFactoryTest {
    @Test
    public void testCreateRating() throws Exception {


        final String description="by jordan";
        Map<String,String> values = new HashMap<String,String>();




        values.put("name","Nike");
        values.put("description",description);



        Rating rating = RatingFactory
                .createRating(values);


        Assert.assertEquals( description,rating.getDescription());
        Assert.assertEquals("Nike",rating.getName());

    }

    @Test
    public void testUpdateRating() throws Exception {


        final String description="by kanye";
        Map<String,String> values = new HashMap<String,String>();




        values.put("name","Nike");
        values.put("description","by jordan");



        Rating rating = RatingFactory
                .createRating(values);

        Rating rating1= new Rating
                .Builder()
                .copy(rating)
                .name("guess")
                .description(description)
                .build();


        Assert.assertEquals("guess",rating1.getName());
        Assert.assertEquals(description,rating1.getDescription());


    }


}
