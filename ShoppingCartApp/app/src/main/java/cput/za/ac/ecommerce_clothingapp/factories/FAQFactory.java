package cput.za.ac.ecommerce_clothingapp.factories;


import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.FAQ;

/**
 * Created by Admin on 2016-05-03.
 */
public class FAQFactory {

    private static  FAQFactory instance=null;

    private FAQFactory(){}

    public static FAQFactory getInstance() {
        if (instance == null) {
            instance = new FAQFactory();

        }
        return instance;
    }

    public static FAQ createFAQ(Map<String,String> value){
        return new FAQ
                .Builder()
                .question(value.get("question"))
                .answer(value.get("answer"))
                .build();


    }
}
