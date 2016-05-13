package cput.za.ac.ecommerce_clothingapp.restapi.resources;
import java.io.Serializable;
import java.util.List;

import cput.za.ac.ecommerce_clothingapp.domain.Product;

/**
 * Created by Admin on 2016-04-29.
 */
public class RatingResource implements Serializable {

    private long id;
    private String name;
    private byte[] image;
    private String description;
    private List<Product > product;






    private RatingResource(){

    }
    public RatingResource(Builder build){
        this.id=build.id;
        this.name=build.name;
        this.image=build.image;
        this.description=build.description;

    }

    public static class Builder{
        private long id;
        private String name;
        private byte[] image;
        private String description;

        public Builder()
        {

        }

        public Builder id(long id)
        {
            this.id=id;
            return  this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder image(byte [] image)
        {
            this.image=image;
            return this;
        }

        public Builder description(String description)
        {
            this.description=description;
            return this;
        }

        public Builder copy(RatingResource value)
        {
            this.id=value.getId();
            this.name=value.getName();
            this.description=value.getDescription();
            this.image=value.getImage();
            return this;
        }

        public RatingResource build(){return new RatingResource(this);}

    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }



}
