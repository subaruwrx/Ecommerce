package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.User;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.UserRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.UserRepository;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.UserResource;
import cput.za.ac.ecommerce_clothingapp.services.UserService;

/**
 * Created by Admin on 2016-05-13.
 */
public class UserServiceImpl extends IntentService implements UserService {

    private UserRepository repository;

    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";


    private static  UserServiceImpl service = null;

    public static UserServiceImpl getInstance() {
        if (service == null)
            service = new  UserServiceImpl();
        return service;
    }

    public  UserServiceImpl() {
        super(" UserServiceImpl");
        repository = new UserRepositoryImpl(App.getAppContext());

    }


    @Override
    public void addUser(Context context, UserResource userResource) {
        Intent intent = new Intent(context,  UserServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, userResource);
        context.startService(intent);

    }

    @Override
    public void   deleteUser(Context context,  UserResource useResource) {
        Intent intent = new Intent(context, UserServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final  UserResource  userResource = (UserResource) intent.getSerializableExtra(EXTRA_ADD);
                addUser( userResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteUser();
            }
        }
    }

    private void deleteUser() {
        repository.deleteAll();
    }

    private void addUser(UserResource   userResource  ) {
        User user= new   User.Builder()
                .firstName(userResource.getFirstName())
                .surName(userResource.getSurName())
                .contactNo(userResource.getContactNo())
                .gender(userResource.getGender())
                .email(userResource.getEmail())
                .description(userResource.getDescription())
                .build();
        User saveUser = repository.save(user);

    }



}
