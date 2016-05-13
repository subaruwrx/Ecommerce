package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.repository.dom.AddressRepository;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.AddressRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.AddressResource;
import cput.za.ac.ecommerce_clothingapp.services.AddressService;

/**
 * Created by Admin on 2016-05-08.
 */

public class AddressServiceImpl extends IntentService implements AddressService {

    private final AddressRepository repository;


    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";



    private static AddressServiceImpl service = null;

    public static AddressServiceImpl getInstance() {
        if (service == null)
            service = new AddressServiceImpl();
        return service;
    }

    public AddressServiceImpl() {
        super("AddressServiceImpl");
        repository = new AddressRepositoryImpl(App.getAppContext());

    }

    @Override
    public void addPersonAddress(Context context, AddressResource addressResource) {
        Intent intent = new Intent(context, AddressServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, addressResource);
        context.startService(intent);
    }



    @Override
    public void deleteAddress(Context context, AddressResource addressResource) {
        Intent intent = new Intent(context, AddressServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final AddressResource addressResource = (AddressResource) intent.getSerializableExtra(EXTRA_ADD);
                saveAddress(addressResource);
            }

            else if (ACTION_DELETE.equals(action)) {
                deleteAddressRecords();
            }
        }
    }

    private void deleteAddressRecords() {
        repository.deleteAll();
    }

    private void saveAddress(AddressResource addressResource) {
        Address address = new Address.Builder()
                .city(addressResource.getCity())
                .street(addressResource.getStreet())
                .country(addressResource.getCountry())
                .zipCode(addressResource.getZipCode())
                .build();
        Address saveAddress = repository.save(address);

    }



}

