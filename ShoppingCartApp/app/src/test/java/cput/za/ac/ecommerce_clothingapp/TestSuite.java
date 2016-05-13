package cput.za.ac.ecommerce_clothingapp;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cput.za.ac.ecommerce_clothingapp.factory.AddressFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.AttributeFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.BrandFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.CategoryFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.FAQFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.OffersFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.OrderDetailsFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.OrderFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.OrderStatusFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.ProductFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.ProductTypeFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.RatingFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.RoleFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.ShoppingCartFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.UserAccountFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.UserFactoryTest;
import cput.za.ac.ecommerce_clothingapp.factory.WishListFactoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressFactoryTest.class,
        AttributeFactoryTest.class,
        BrandFactoryTest.class,
        CategoryFactoryTest.class,
        FAQFactoryTest.class,
        OffersFactoryTest.class,
        OrderDetailsFactoryTest.class,
        OrderFactoryTest.class,
        OrderStatusFactoryTest.class,
        WishListFactoryTest.class,
        UserFactoryTest.class,
        UserAccountFactoryTest.class,
        ShoppingCartFactoryTest.class,
        RoleFactoryTest.class,
        RatingFactoryTest.class,
        ProductTypeFactoryTest.class,
        ProductFactoryTest.class






})
public class TestSuite {
}
