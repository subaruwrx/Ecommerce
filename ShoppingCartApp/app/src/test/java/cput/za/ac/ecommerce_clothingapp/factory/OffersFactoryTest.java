package cput.za.ac.ecommerce_clothingapp.factory;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Offers;
import cput.za.ac.ecommerce_clothingapp.factories.OffersFactory;


/**
 * Created by Admin on 2016-04-29.
 */
public class OffersFactoryTest {

    @Test
    public void testCreateOffers() throws Exception {

        final double offerPrice=300.00;
        final String description="by jordan";
        Map<String,Date> date = new HashMap<String,Date>();




       // date.put("StartDate",);
       // date.put("productType","Sneaker");


        Offers offers = OffersFactory
                .createOffer(offerPrice,description);


        Assert.assertEquals( description,offers.getDescription());

    }

    @Test
    public void testUpdateOffers() throws Exception {


        final double offerPrice=300.00;
        final String description="by jordan";
        Map<String,Date> date = new HashMap<String,Date>();




        // date.put("StartDate",);
        // date.put("productType","Sneaker");


        Offers offers = OffersFactory
                .createOffer(offerPrice,description);


        Offers offers1= new Offers
                .Builder()
                .copy(offers)
                .offerPrice(400.00)
                .description("by Kanye west")
                .build();

        Assert.assertEquals("by Kanye west",offers1.getDescription());

    }


}
