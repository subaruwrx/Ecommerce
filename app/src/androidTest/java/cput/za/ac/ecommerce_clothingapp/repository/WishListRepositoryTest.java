package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.config.util.AppUtil;
import cput.za.ac.ecommerce_clothingapp.domain.WishList;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.WishListRepoditoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.WishListRepository;

/**
 * Created by Admin on 2016-05-03.
 */
public class WishListRepositoryTest  extends AndroidTestCase {

    private static final String TAG = "wishList";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        WishListRepository repo = new WishListRepoditoryImpl(this.getContext());

        // CREATE
        WishList createEntity = new  WishList.Builder()
                .name("Fossil watch")
                //.customerId()
                .insertDate(AppUtil.getDate("4-May-2016"))
                .build();



        WishList  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<WishList > wish= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",wish.size()>0);

        //READ ENTITY
        WishList entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        WishList updateEntity = new WishList .Builder()
                .name("Police watch")
                //.customerId()
                .insertDate(AppUtil.getDate("6-May-2016"))
                .build();
        repo.update(updateEntity);
        WishList newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","accountNumber",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        WishList  deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
