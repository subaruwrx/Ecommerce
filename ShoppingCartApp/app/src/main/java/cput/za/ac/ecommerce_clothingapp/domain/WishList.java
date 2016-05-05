package cput.za.ac.ecommerce_clothingapp.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2016-04-30.
 */
public class WishList {
    private Long id;
    private Long customerId;
    private Long productId;
    private String name;
    private Date insertDate;
    private List<Product> products;
    private List<User> user;



    private WishList()
    {

    }

    public WishList(Builder build)
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

        public Builder copy(WishList list)
        {
            this.id=list.getId();
            this.customerId=list.getCustomerId();
            this.productId=list.getProductId();
            this.name=list.getName();
            this.insertDate=list.getInsertDate();

            return  this;
        }


        public WishList  build() {return  new WishList(this);}
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
