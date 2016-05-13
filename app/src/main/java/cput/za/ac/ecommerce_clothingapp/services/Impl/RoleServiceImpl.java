package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.Role;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.RoleRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.RoleRepository;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.RoleResource;
import cput.za.ac.ecommerce_clothingapp.services.RoleService;

/**
 * Created by Admin on 2016-05-13.
 */
public class RoleServiceImpl extends IntentService implements RoleService {

    private RoleRepository repository;

    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";


    private static  RoleServiceImpl service = null;

    public static RoleServiceImpl getInstance() {
        if (service == null)
            service = new  RoleServiceImpl();
        return service;
    }

    public  RoleServiceImpl() {
        super(" RoleServiceImpl");
        repository = new RoleRepositoryImpl(App.getAppContext());

    }


    @Override
    public void  addRole(Context context, RoleResource roleResource) {
        Intent intent = new Intent(context,  RoleServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,roleResource);
        context.startService(intent);

    }

    @Override
    public void   deleteRole(Context context,RoleResource roleResource) {
        Intent intent = new Intent(context, RoleServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final  RoleResource  roleResource = (RoleResource) intent.getSerializableExtra(EXTRA_ADD);
                addRole( roleResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteRole();
            }
        }
    }

    private void  deleteRole() {
        repository.deleteAll();
    }

    private void  addRole(RoleResource  roleResource  ) {
        Role role= new  Role.Builder()
               .role(roleResource.getRole())
                .description(roleResource.getDescription())
                .build();
        Role saveRole = repository.save(role);

    }




}
