package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.domain.FAQ;
import cput.za.ac.ecommerce_clothingapp.repository.dom.FAQRepository;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.FAQRepositoryImpl;

/**
 * Created by Admin on 2016-05-10.
 */
public class FAQRepositoryTest extends AndroidTestCase {

    private static final String TAG = "FAQ";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        FAQRepository repo = new FAQRepositoryImpl(this.getContext());

        // CREATE
        FAQ createEntity = new  FAQ.Builder()
                .question("how do you delete from cart")
                .answer("client on the item and click the delete buttton")
                .build();



        FAQ insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<FAQ> faq= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",faq.size()>0);

        //READ ENTITY
        FAQ entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        FAQ updateEntity = new FAQ.Builder()
                .copy(entity)
                .question("how do you add to cart")
                .build();
        repo.update(updateEntity);
        FAQ newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","how do you add to cart",newEntity.getQuestion());

        // DELETE ENTITY
        repo.delete(updateEntity);
        FAQ deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
