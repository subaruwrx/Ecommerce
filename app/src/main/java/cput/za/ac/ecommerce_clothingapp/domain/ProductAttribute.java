package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2016-05-03.
 */
public class ProductAttribute implements Serializable {
    private Long productId;
    private Long attributeId;
    private List<Product > product;


    private ProductAttribute(){}
    public ProductAttribute(Builder build){

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

        public Builder copy(ProductAttribute values){
            this.attributeId=values.getAttributeId();
            this.productId=values.getProductId();
            return this;

        }

        public ProductAttribute build(){return new ProductAttribute(this);}
    }
    public Long getProductId() {
        return productId;
    }

    public Long getAttributeId() {
        return attributeId;
    }




}
