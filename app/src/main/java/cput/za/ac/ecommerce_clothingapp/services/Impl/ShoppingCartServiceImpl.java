package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.ShoppingCart;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.ShoppingCartRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.ShoppingCartRepository;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.ShoppingCartResource;
import cput.za.ac.ecommerce_clothingapp.services.ShoppingCartService;

/**
 * Created by Admin on 2016-05-13.
 */
public class ShoppingCartServiceImpl extends IntentService implements ShoppingCartService {

    private ShoppingCartRepository repository;

    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";


    private static  ShoppingCartServiceImpl service = null;

    public static ShoppingCartServiceImpl getInstance() {
        if (service == null)
            service = new   ShoppingCartServiceImpl();
        return service;
    }

    public   ShoppingCartServiceImpl() {
        super(" ShoppingCartServiceImpl");
        repository = new ShoppingCartRepositoryImpl(App.getAppContext());

    }


    @Override
    public void  addCart(Context context,ShoppingCartResource shoppingCartResource) {
        Intent intent = new Intent(context, ShoppingCartServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,shoppingCartResource);
        context.startService(intent);

    }

    @Override
    public void   deleteCart(Context context,ShoppingCartResource shoppingCartResource) {
        Intent intent = new Intent(context, ShoppingCartServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final ShoppingCartResource  shoppingCartResource= (ShoppingCartResource) intent.getSerializableExtra(EXTRA_ADD);
                addCart( shoppingCartResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteCart();
            }
        }
    }

    private void  deleteCart() {
        repository.deleteAll();
    }

    private void   addCart(ShoppingCartResource  shoppingCartResource  ) {
        ShoppingCart cart= new  ShoppingCart.Builder()
                .dateCreated(shoppingCartResource.getCreated())
                .price(shoppingCartResource.getPrice())
                .quantity(shoppingCartResource.getQauntity())
                .build();
        ShoppingCart saveCart = repository.save(cart);

    }


}
