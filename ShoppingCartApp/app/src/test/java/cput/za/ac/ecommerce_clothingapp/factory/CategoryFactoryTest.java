package cput.za.ac.ecommerce_clothingapp.factory;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Category;
import cput.za.ac.ecommerce_clothingapp.factories.CategoryFactory;


/**
 * Created by Admin on 2016-05-03.
 */
public class CategoryFactoryTest {
    @Test
    public void testCreateCategory() throws Exception {


        final String description="leather jacket";
        Map<String,String> values = new HashMap<String,String>();


        values.put("name","Clothing");
        values.put("description",description);



        Category category = CategoryFactory
                .createCategory(values);


        Assert.assertEquals( description,category.getDescription());
        Assert.assertEquals("Clothing",category.getName());

    }

    @Test
    public void testUpdateRating() throws Exception {


        final String description="leather shoes";
        Map<String,String> values = new HashMap<String,String>();


        values.put("name","Clothing");
        values.put("description","t-shirt");



        Category category = CategoryFactory
                .createCategory(values);


        Category category1= new  Category
                .Builder()
                .copy(category)
                .name("Shoes")
                .description(description)
                .build();


        Assert.assertEquals("Shoes", category1.getName());
        Assert.assertEquals(description, category1.getDescription());


    }


}
