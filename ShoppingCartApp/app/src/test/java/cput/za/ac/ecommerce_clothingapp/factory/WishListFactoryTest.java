package cput.za.ac.ecommerce_clothingapp.factory;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import cput.za.ac.ecommerce_clothingapp.domain.WishList;
import cput.za.ac.ecommerce_clothingapp.factories.WishListFactory;

/**
 * Created by Admin on 2016-05-02.
 */
public class WishListFactoryTest {
    @Test
    public void testCreateWishList() throws Exception {
        final String name="Nike sneakers";
        Date insertDate =new Date();



        WishList wishList = WishListFactory
                .createWishList(name,insertDate);

        Assert.assertEquals(name,wishList.getName() );
        Assert.assertEquals(insertDate,wishList.getInsertDate());

    }


    @Test
    public void testUpdateWhishList() throws Exception {


            //final String name="Nike sneakers";
            Date insertDate =new Date();



            WishList wishList = WishListFactory
                    .createWishList("Addidas",insertDate);


            WishList wishList1= new  WishList
                .Builder()
                .copy(wishList)
                .name("Nike")
                .insertDate(insertDate)
                .build();
        Assert.assertEquals("Nike",wishList1.getName());
        Assert.assertEquals(insertDate,wishList1.getInsertDate());


    }

}
