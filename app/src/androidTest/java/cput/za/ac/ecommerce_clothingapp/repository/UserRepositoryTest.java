package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.domain.User;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.UserRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.UserRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class UserRepositoryTest extends AndroidTestCase {
    private static final String TAG = "user";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        UserRepository repo = new UserRepositoryImpl(this.getContext());

        // CREATE
        User createEntity = new  User.Builder()
                .firstName("Sihle")
                .surName("Ngoniwe")
                .gender("female")
                .contactNo("078 382 2938")
                .email("sihle.ngoniwe@gmail.com")
                .description("user")
                .build();


        User  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getUserId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<User> user= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",user.size()>0);

        //READ ENTITY
        User entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        User  updateEntity = new  User.Builder()
                .firstName("Sibabalwe")
                .surName("Dike")
                .gender("male")
                .contactNo("081 894 1030")
                .email("sibabalwedike@gmail.com")
                .description("Admin")
                .build();

        repo.update(updateEntity);
        User  newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","id",newEntity.getUserId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        User  deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
