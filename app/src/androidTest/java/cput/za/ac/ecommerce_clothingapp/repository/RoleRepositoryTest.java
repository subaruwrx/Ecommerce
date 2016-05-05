package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;
import junit.framework.Assert;
import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.domain.Role;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.RoleRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.RoleRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class RoleRepositoryTest extends AndroidTestCase {

    private static final String TAG = "role";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        RoleRepository repo = new RoleRepositoryImpl(this.getContext());

        // CREATE
       Role createEntity = new  Role.Builder()
               .role("User")
               .description("follow instructions")
               .build();



       Role  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Role> role= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",role.size()>0);

        //READ ENTITY
        Role entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        Role  updateEntity = new  Role.Builder()
                .role("User")
                .description("follow instructions")
                .build();
        repo.update(updateEntity);
        Role newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","id",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Role  deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }



}
