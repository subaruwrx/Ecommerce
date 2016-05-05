package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 2016-04-29.
 */
public class Offers implements Serializable {
    private long id;
    private long productId;
    private double offerPrice;
    private String description;
    private Date offerStartDate;
    private Date offerEndDate;
    private Product product;


    private Offers(){

    }

    public Offers(Builder build)
    {
        this.id=build.id;
        this.productId=build.productId;
        this.offerPrice=build.offerPrice;
        this.description=build.description;
        this.offerStartDate=build.offerStartDate;
        this.offerEndDate=build.offerEndDate;

    }

    public static class Builder{
        private long id;
        private long productId;
        private double offerPrice;
        private String description;
        private Date offerStartDate;
        private Date offerEndDate;


        public Builder()
        {

        }

        public Builder id(long id)
        {
            this.id=id;
            return this;
        }

        public Builder productId(long productId)
        {
            this.productId=productId;
            return this;
        }

        public Builder offerPrice(double offerPrice)
        {
            this.offerPrice=offerPrice;
            return this;
        }

        public Builder description(String description)
        {
            this.description=description;
            return this;
        }

        public Builder offerStartDate(Date offerStartDate)
        {
            this.offerStartDate=offerStartDate;
            return this;
        }

        public Builder offerEndDate(Date offerEndDate)
        {
            this.offerEndDate=offerEndDate;
            return this;
        }

        public Builder copy(Offers value)
        {
            this.id=value.getId();
            this.productId=value.getProductId();
            this.description=value.getDescription();
            this.offerPrice=value.getOfferPrice();
            this.offerStartDate=value.getOfferStartDate();
            this.offerEndDate=value.getOfferEndDate();
            return this;
        }


        public Offers build(){return new Offers(this);}

    }
    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public String getDescription() {
        return description;
    }

    public Date getOfferStartDate() {
        return offerStartDate;
    }

    public Date getOfferEndDate() {
        return offerEndDate;
    }
}
