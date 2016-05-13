package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-05-03.
 */
public class Attributes implements Serializable {
    private Long id;
    private String attributeName;
    private String attributeValue;
    private String description;
    private ProductAttribute attributes;

    private Attributes(){}

    public Attributes(Builder build){
        this.id=build.id;
        this.attributeName=build.attributeName;
        this.attributeValue=build.attributeValue;
        this.description=build.description;

    }

    public static  class Builder{
        private Long id;
        private String attributeName;
        private String attributeValue;
        private String description;

        public Builder()
        {

        }

        public Builder id(Long id){
            this.id=id;
            return this;

        }
        public  Builder attributeName(String attributeName){
            this.attributeName=attributeName;
            return this;
        }

        public Builder  attributeValue(String attributeValue){
            this.attributeValue=attributeValue;
            return this;
        }
        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder copy(Attributes value){
            this.id=value.getId();
            this.attributeName=value.getAttributeName();
            this.attributeValue=value.getAttributeValue();
            this.description=value.getDescription();
            return this;
        }

        public Attributes build(){return new Attributes(this);}

    }

    public Long getId() {
        return id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public String getDescription() {
        return description;
    }
}
