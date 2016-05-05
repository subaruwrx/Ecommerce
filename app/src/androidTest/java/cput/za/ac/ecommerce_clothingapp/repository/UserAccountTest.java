package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.domain.UserAccount;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.UserAccountRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.UserAccountRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class UserAccountTest  extends AndroidTestCase {

    private static final String TAG = "userAccount";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        UserAccountRepository repo = new UserAccountRepositoryImpl(this.getContext());

        // CREATE
        UserAccount createEntity = new  UserAccount.Builder()
                .userName("Dik212039210")
                .password("******")
                .hintQuestion("what's your favourite car")
                .answer("Maserati")
                .description("v8 motor")
                .build();



        UserAccount  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<UserAccount> userAccounts= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",userAccounts.size()>0);

        //READ ENTITY
        UserAccount entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        UserAccount  updateEntity = new  UserAccount.Builder()
                .userName("Ver212039212")
                .password("*******")
                .hintQuestion("what's your favourite car")
                .answer("Bugatti")
                .description("v12 twin turbo motor")
                .build();
        repo.update(updateEntity);
        UserAccount  newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","id",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        UserAccount  deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
