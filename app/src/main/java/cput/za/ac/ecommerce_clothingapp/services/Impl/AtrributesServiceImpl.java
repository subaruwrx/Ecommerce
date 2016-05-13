package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.Attributes;
import cput.za.ac.ecommerce_clothingapp.repository.dom.AttributesRepository;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.AttributesRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.AttributesResource;
import cput.za.ac.ecommerce_clothingapp.services.AttributesService;

/**
 * Created by Admin on 2016-05-13.
 */
public class AtrributesServiceImpl extends IntentService implements AttributesService {

    private final AttributesRepository repository;


    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";
    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";



    private static AtrributesServiceImpl service = null;

    public static AtrributesServiceImpl getInstance() {
        if (service == null)
            service = new AtrributesServiceImpl();
        return service;
    }

    public AtrributesServiceImpl() {
        super("AtrributesServiceImpl");
        repository = new AttributesRepositoryImpl(App.getAppContext());

    }




    @Override
    public void addAttributes(Context context, AttributesResource attributesResource) {
        Intent intent = new Intent(context,  AtrributesServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, attributesResource);
        context.startService(intent);

    }

    @Override
    public void  deleteAttributes(Context context,  AttributesResource attributesResource) {
        Intent intent = new Intent(context, AtrributesServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final AttributesResource attributesResource = (AttributesResource) intent.getSerializableExtra(EXTRA_ADD);
                saveAttributes(attributesResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteAttributes();
            }
        }
    }

    private void deleteAttributes() {
        repository.deleteAll();
    }

    private void saveAttributes(AttributesResource  attributesResource ) {
        Attributes attributes = new  Attributes.Builder()
                .attributeName(attributesResource.getAttributeName())
                .attributeValue(attributesResource.getAttributeValue())
                .description(attributesResource.getDescription())
                .build();
        Attributes saveattributes = repository.save(attributes);

    }



}