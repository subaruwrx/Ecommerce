package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.config.util.AppUtil;
import cput.za.ac.ecommerce_clothingapp.domain.ShoppingCart;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.ShoppingCartRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.ShoppingCartRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class ShoppingCartRepositoryTest  extends AndroidTestCase {

    private static final String TAG = "shoppingCart";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        ShoppingCartRepository repo = new ShoppingCartRepositoryImpl(this.getContext());

        // CREATE
        ShoppingCart createEntity = new  ShoppingCart.Builder()
                .price(400.00)
                .quantity(4)
                .dateCreated(AppUtil.getDate("4-May-2016"))
                .build();




        ShoppingCart  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<ShoppingCart> cart= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",cart.size()>0);

        //READ ENTITY
        ShoppingCart entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        ShoppingCart  updateEntity = new  ShoppingCart.Builder()
                .price(400.00)
                .quantity(4)
                .dateCreated(AppUtil.getDate("4-May-2016"))
                .build();
        repo.update(updateEntity);
        ShoppingCart  newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","id",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        ShoppingCart  deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
