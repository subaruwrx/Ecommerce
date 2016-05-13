package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;
import java.util.List;

import cput.za.ac.ecommerce_clothingapp.domain.Product;

/**
 * Created by Admin on 2016-05-03.
 */
public class ProductAttributeResource implements Serializable {
    private Long productId;
    private Long attributeId;
    private List<Product > product;


    private ProductAttributeResource(){}
    public ProductAttributeResource(Builder build){

    }

    public static class Builder{
        private Long productId;
        private Long attributeId;

        public Builder(){}

        public Builder productId(Long productId)
        {
            this.productId=productId;
            return this;
        }

        public Builder attributeId(Long attributeId){
            this.attributeId=attributeId;
            return this;
        }

        public Builder copy(ProductAttributeResource values){
            this.attributeId=values.getAttributeId();
            this.productId=values.getProductId();
            return this;

        }

        public ProductAttributeResource build(){return new ProductAttributeResource(this);}
    }
    public Long getProductId() {
        return productId;
    }

    public Long getAttributeId() {
        return attributeId;
    }




}
