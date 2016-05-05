package cput.za.ac.ecommerce_clothingapp.factories;

import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Rating;

/**
 * Created by Admin on 2016-04-30.
 */
public class RatingFactory {
    private static  RatingFactory instance=null;

    private RatingFactory(){}

    public static RatingFactory getInstance() {
        if (instance == null) {
            instance = new RatingFactory();

        }
        return instance;
    }

    public static Rating createRating(Map<String,String> value){
        return new Rating.Builder()
                .name(value.get("name"))
                .description(value.get("description"))
                .build();


    }
}
