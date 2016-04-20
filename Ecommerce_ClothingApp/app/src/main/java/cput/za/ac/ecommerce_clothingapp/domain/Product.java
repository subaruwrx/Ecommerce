package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-04-20.
 */
public class Product implements Serializable {
    private long prodId;
    private String prodName;
    private String prodtype;
    private String prodsize;
    private int prodquantity;

    private Product()
    {
    }

    private Product (Builder build)
    {
        prodId=build.prodId;
        prodName=build.prodName;
        prodtype=build.prodtype;
        prodsize=build.prodsize;
        prodquantity=build.prodquantity;

    }



    public static class Builder{

        private long prodId;
        private String prodName;
        private String prodtype;
        private String prodsize;
        private int prodquantity;

        public Builder () {

        }
        public Builder id(long id) {
            this.prodId = prodId;
            return this;
        }


        public Builder productName(String prodName){
            this.prodName= prodName;
            return this ;
        }

        public Builder productType(String prodtype){
            this.prodtype= prodtype;
            return this;
        }

        public Builder productQuantity(int prodquantity){
            this.prodquantity= prodquantity;
            return this;

        }

        public Builder productMethod(String prodsize){
            this.prodsize=prodsize;
            return this;
        }


        public Builder copy(Product value)
        {

            this.prodId = value.getProdId();
            this.prodName =value.getProdName();
            this.prodtype = value.getProdtype();
            this.prodsize = value.getProdsize();
            this.prodquantity= value.getProdquantity();

            return this;
        }


        public Product build()
        {
            return new Product(this);
        }
    }

    public long getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdtype() {
        return prodtype;
    }

    public String getProdsize() {
        return prodsize;
    }

    public int getProdquantity() {
        return prodquantity;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + prodId + '}';
    }
}

