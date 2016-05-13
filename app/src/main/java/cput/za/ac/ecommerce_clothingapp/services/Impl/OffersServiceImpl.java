package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.Offers;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.OffersRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.repository.dom.OffersRepository;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.OffersResource;
import cput.za.ac.ecommerce_clothingapp.services.OffersService;

/**
 * Created by Admin on 2016-05-13.
 */
public class OffersServiceImpl  extends IntentService implements OffersService {

    private OffersRepository repository;

    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";


    private static  OffersServiceImpl service = null;

    public static  OffersServiceImpl getInstance() {
        if (service == null)
            service = new  OffersServiceImpl();
        return service;
    }

    public  OffersServiceImpl() {
        super(" OffersServiceImpl");
        repository = new OffersRepositoryImpl(App.getAppContext());

    }


    @Override
    public void  addOffers(Context context,OffersResource offersResource) {
        Intent intent = new Intent(context,  OffersServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,offersResource);
        context.startService(intent);

    }

    @Override
    public void   deleteOffers(Context context,OffersResource offersResource) {
        Intent intent = new Intent(context, OffersServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final  OffersResource  offersResource = (OffersResource) intent.getSerializableExtra(EXTRA_ADD);
                addOffers( offersResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteOffers();
            }
        }
    }

    private void  deleteOffers() {
        repository.deleteAll();
    }

    private void addOffers(OffersResource offersResource  ) {
       Offers offers= new  Offers.Builder()
               .offerStartDate(offersResource.getOfferStartDate())
               .offerEndDate(offersResource.getOfferEndDate())
               .description(offersResource.getDescription())
               .offerPrice(offersResource.getOfferPrice())
                .build();
        Offers saveOffers = repository.save(offers);

    }




}
