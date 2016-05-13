package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import cput.za.ac.ecommerce_clothingapp.domain.Product;

/**
 * Created by Admin on 2016-04-13.
 */
public class ShoppingCartResource implements Serializable {

    private Long id;
    private Long sessionId;
    private Long productId;
    private Date created;
    private int quantity;
    private double price;
    private List<Product> products;



    private ShoppingCartResource(){}

    public ShoppingCartResource(Builder build){
        this.id=build.id;
        this.created=build.created;
        this.sessionId=build.sessionId;
        this.productId=build.productId;
        this.quantity=build.quantity;
        this.price=build.price;

    }

    public static class Builder{
        private Long id;
        private Long sessionId;
        private Long productId;
        private Date created;
        private int quantity;
        private double price;

        public Builder(){

        }


        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder sessionId(Long sessionId){
            this.sessionId=sessionId;
            return this;
        }

        public Builder productId(Long productId){
            this.productId=productId;
            return  this;
        }
        public Builder dateCreated(Date created)
        {
            this.created=created;
            return this;
        }


        public Builder quantity(int quantity){
            this.quantity=quantity;
            return  this;
        }
        public Builder price(double price)
        {
            this.price=price;
            return this;
        }

        public Builder copy(ShoppingCartResource value)
        {

            this.id=value.getId();
            this.created=value.getCreated();
            this.sessionId=value.getSessionId();
            this.productId=value.getProductId();
            this.quantity=value.getQauntity();
            this.price=value.getPrice();

            return this;
        }

        public ShoppingCartResource build()
        {
            return new ShoppingCartResource(this);
        }

    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public int getQauntity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }


    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShoppingCartResource other = (ShoppingCartResource) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Shopping cart id{" + ":" + id+ '}';
    }
}
