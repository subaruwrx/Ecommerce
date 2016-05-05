package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.domain.Attributes;
import cput.za.ac.ecommerce_clothingapp.repository.dom.AttributesRepository;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.AttributesRepositoryImpl;


/**
 * Created by Admin on 2016-04-25.
 */
public class AttributesRepositoryTest extends AndroidTestCase {

    private static final String TAG = "attributes";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        AttributesRepository repo = new AttributesRepositoryImpl(this.getContext());

        // CREATE
        Attributes createEntity = new  Attributes.Builder()
                .attributeName("size")
                .attributeValue("8 UK")
                .description("Addidas Sneakers")
                .build();



        Attributes  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Attributes> attributes= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",attributes.size()>0);

        //READ ENTITY
        Attributes entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        Attributes updateEntity = new Attributes.Builder()
                .attributeName("color")
                .attributeValue("red")
                .description("Nike Sneakers")
                .build();
        repo.update(updateEntity);
        Attributes newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","accountNumber",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Attributes deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
