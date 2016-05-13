package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;
import java.util.List;

import cput.za.ac.ecommerce_clothingapp.domain.Product;

/**
 * Created by Admin on 2016-05-03.
 */
public class CategoryResource implements Serializable {
    private Long id;
    private String name;
    private String description;
    private byte[] image;
    private List<Product > product;

    private CategoryResource(){}

    public CategoryResource(Builder build)
    {
        this.id=build.id;
        this.name=build.name;
        this.image=build.image;
        this.description=build.description;
    }
    public static class Builder{
        private Long id;
        private String name;
        private String description;
        private byte[] image;


        public Builder(){

        }

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder image(byte[] image){
            this.image=image ;
            return this;
        }


        public Builder  description(String  description){
            this.description=description;
            return this;
       }

        public Builder copy(CategoryResource values){
            this.id=values.getId();
            this.name=values.getName();
            this.description=values.getDescription();
            this.image=values.getImage();
            return this;
        }

        public CategoryResource build(){return new CategoryResource(this);}


}
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }
}
