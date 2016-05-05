package cput.za.ac.ecommerce_clothingapp.repository;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.repository.dom.AddressRepository;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.AddressRepositoryImpl;

/**
 * Created by Admin on 2016-04-25.
 */
public class AddressRepositoryTest  extends AndroidTestCase {

    private static final String TAG = "ADDRESS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        AddressRepository repo = (AddressRepository) new AddressRepositoryImpl(this.getContext());
        // CREATE
       Address createEntity = new  Address.Builder()
                 .city("summer greens")
                 .street("24 tienkers road")
                 .country("South africa")
                 .zipCode("8000")
                .build();



        Address  insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Address> addres = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",addres.size()>0);

        //READ ENTITY
        Address entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Address updateEntity = new Address.Builder()
                .city("Cape town,Zonnebloem")
                .street("24 caledon street")
                .country("South africa")
                .zipCode("8001")
                .build();
        repo.update(updateEntity);
        Address newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","city",newEntity.getCity());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Address deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
