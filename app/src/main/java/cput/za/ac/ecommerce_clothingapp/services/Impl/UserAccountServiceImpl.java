package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.UserAccount;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.UserAccountRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.UserAccountRepository;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.UserAccountResource;
import cput.za.ac.ecommerce_clothingapp.services.UserAccountService;

/**
 * Created by Admin on 2016-05-08.
*/

public class UserAccountServiceImpl extends IntentService implements UserAccountService {

    private UserAccountRepository  repository;

    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";


    private static UserAccountServiceImpl service = null;

    public static UserAccountServiceImpl getInstance() {
        if (service == null)
            service = new UserAccountServiceImpl();
        return service;
    }

    public UserAccountServiceImpl() {
        super("UserAccountServiceImpl");
        repository = new UserAccountRepositoryImpl(App.getAppContext());

    }


    @Override
    public void addUserAccount(Context context,UserAccountResource userAccountResource) {
        Intent intent = new Intent(context,  UserAccountServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, userAccountResource);
        context.startService(intent);

    }

    @Override
    public void   deleteUserAccount(Context context,  UserAccountResource userAccountResource) {
        Intent intent = new Intent(context, UserAccountServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final  UserAccountResource  userAccountResource = (UserAccountResource) intent.getSerializableExtra(EXTRA_ADD);
                addUserAccount( userAccountResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteUserAccount();
            }
        }
    }

    private void deleteUserAccount() {
        repository.deleteAll();
    }

    private void addUserAccount(UserAccountResource   userAccountResource  ) {
        UserAccount user= new   UserAccount.Builder()
                .userName(userAccountResource.getUserName())
                .password(userAccountResource.getPassword())
                .hintQuestion(userAccountResource.getHintQuestion())
                .answer(userAccountResource.getAnswer())
                .description(userAccountResource.getDescription())
                .build();
        UserAccount saveUserAccount = repository.save(user);

    }




}



