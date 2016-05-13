package cput.za.ac.ecommerce_clothingapp.restapi.resources;
import java.io.Serializable;

import cput.za.ac.ecommerce_clothingapp.domain.Product;

/**
 * Created by Admin on 2016-05-03.
 */
public class ProductTypeResource implements Serializable{
    private Long id;
    private String name;
    private String description;
    private Product product;



    private ProductTypeResource(){

    }

    public ProductTypeResource(Builder build){
        this.id=build.id;
        this.name=build.name;
        this.description=build.description;

    }
    public static class Builder{
        private Long id;
        private String name;
        private String description;

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

        public Builder  description(String  description){
            this.description=description;
            return this;
        }

        public Builder copy(ProductTypeResource values)
        {
            this.id=values.getId();
            this.name=values.getName();
            this.description=values.getDescription();
            return this;
        }

        public ProductTypeResource build(){return new ProductTypeResource(this);}
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

}
