package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.util.Date;
import java.util.List;

import cput.za.ac.ecommerce_clothingapp.domain.Product;
import cput.za.ac.ecommerce_clothingapp.domain.User;

/**
 * Created by Admin on 2016-04-30.
 */
public class WishListResource {
    private Long id;
    private Long customerId;
    private Long productId;
    private String name;
    private Date insertDate;
    private List<Product> products;
    private List<User> user;



    private WishListResource()
    {

    }

    public WishListResource(Builder build)
    {
        this.id=build.id;
        this.customerId=build.customerId;
        this.productId=build.productId;
        this.name=build.name;
        this.insertDate=build.insertDate;

    }
    public  static class Builder{

        private Long id;
        private Long customerId;
        private Long productId;
        private String name;
        private Date insertDate;

        public Builder()
        {

        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }

        public Builder customerId(Long customerId){
            this.customerId=customerId;
            return this;
        }

        public Builder productId(Long productId)
        {
            this.productId=productId;
            return this;
        }

        public Builder name(String name)
        {
            this.name=name;
            return this;
        }

        public Builder insertDate(Date insertDate){
            this.insertDate=insertDate;
            return  this;
        }

        public Builder copy(WishListResource list)
        {
            this.id=list.getId();
            this.customerId=list.getCustomerId();
            this.productId=list.getProductId();
            this.name=list.getName();
            this.insertDate=list.getInsertDate();

            return  this;
        }


        public WishListResource build() {return  new WishListResource(this);}
    }



    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Date getInsertDate() {
        return insertDate;
    }

}
