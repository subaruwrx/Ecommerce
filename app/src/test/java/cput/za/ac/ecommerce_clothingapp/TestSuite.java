package cput.za.ac.ecommerce_clothingapp;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cput.za.ac.ecommerce_clothingapp.repository.AddressFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.AttributeFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.BrandFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.CategoryFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.FAQFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.OffersFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.OrderDetailsFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.OrderFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.OrderStatusFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.ProductFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.ProductTypeFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.RatingFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.RoleFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.ShoppingCartFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.UserAccountFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.UserFactoryTest;
import cput.za.ac.ecommerce_clothingapp.repository.WishListFactoryTest;

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
