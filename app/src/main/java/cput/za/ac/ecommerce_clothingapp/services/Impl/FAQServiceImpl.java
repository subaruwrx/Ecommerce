package cput.za.ac.ecommerce_clothingapp.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import cput.za.ac.ecommerce_clothingapp.config.util.App;
import cput.za.ac.ecommerce_clothingapp.domain.FAQ;
import cput.za.ac.ecommerce_clothingapp.repository.dom.FAQRepository;
import cput.za.ac.ecommerce_clothingapp.repository.dom.Impl.FAQRepositoryImpl;
import cput.za.ac.ecommerce_clothingapp.restapi.resources.FAQResource;
import cput.za.ac.ecommerce_clothingapp.services.FAQService;

/**
 * Created by Admin on 2016-05-13.
 */
public class FAQServiceImpl extends IntentService implements FAQService {

    private final FAQRepository repository;


    private static final String ACTION_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.action.ADD";
    private static final String ACTION_DELETE = "cput.za.ac.ecommerce_clothingapp.services.impl.action.DELETE ";
    // TODO: Rename parameters
    private static final String EXTRA_ADD = "cput.za.ac.ecommerce_clothingapp.services.impl.extra.ADD";



    private static FAQServiceImpl service = null;

    public static FAQServiceImpl getInstance() {
        if (service == null)
            service = new FAQServiceImpl();
        return service;
    }

    public FAQServiceImpl() {
        super("FAQServiceImpl");
        repository = new FAQRepositoryImpl(App.getAppContext());

    }




    @Override
    public void addFAQ(Context context, FAQResource faqResource ) {
        Intent intent = new Intent(context,  FAQServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, faqResource);
        context.startService(intent);

    }

    @Override
    public void  deleteFAQ(Context context,  FAQResource  faqResource) {
        Intent intent = new Intent(context, AtrributesServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final FAQResource faqResource = (FAQResource) intent.getSerializableExtra(EXTRA_ADD);
               addFAQ(faqResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteFAQ();
            }
        }
    }

    private void deleteFAQ() {
        repository.deleteAll();
    }

    private void  addFAQ( FAQResource  faqResource ) {
        FAQ faq= new   FAQ.Builder()
                .question(faqResource.getQuestion())
                .answer(faqResource.getAnswer())
                .build();
        FAQ saveFaq = repository.save(faq);

    }



}
