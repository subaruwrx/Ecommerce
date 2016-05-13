package cput.za.ac.ecommerce_clothingapp.domain;
import java.io.Serializable;

/**
 * Created by Admin on 2016-05-03.
 */
public class ProductType implements Serializable{
    private Long id;
    private String name;
    private String description;
    private Product product;



    private ProductType(){

    }

    public ProductType(Builder build){
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

        public Builder copy(ProductType values)
        {
            this.id=values.getId();
            this.name=values.getName();
            this.description=values.getDescription();
            return this;
        }

        public ProductType build(){return new ProductType(this);}
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
