package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import cput.za.ac.ecommerce_clothingapp.domain.Address;

/**
 * Created by Admin on 2016-04-12.
 */
public class OrderResource implements Serializable {

    private Long orderId;
    private Long customerId;
    private Long shippingAddresId;
    private Long billingAddressId;
    private Date orderDate;
    private Date shippingDate;
    private double orderAmount;
    private double discount;
    private double shippingAmount;
    private double taxAmount;
    private double netAmount;
    private Address address;



    private OrderResource(){


    }

    public OrderResource(Builder build){
        this.orderId=build.orderId;
        this.customerId=build.customerId;
        this.billingAddressId=build.billingAddressId;
        this.shippingAddresId=build.shippingAddressId;
        this.orderDate=build.orderDate;;
        this.shippingDate=build.shippingDate;
        this.orderAmount=build.orderAmount;
        this.discount=build.discount;
        this.shippingAmount=build.shippingAmount;
        this.taxAmount=build.taxAmount;
        this.netAmount=build.netAmount;



    }


    public static class Builder{
        private Long orderId;
        private Long customerId;
        private Long shippingAddressId;
        private Long billingAddressId;
        private Date orderDate;
        private Date shippingDate;
        private double orderAmount;
        private double discount;
        private double shippingAmount;
        private double taxAmount;
        private double netAmount;


        public Builder(){

        }
        public Builder orderId(Long orderId)
        {
            this.orderId=orderId;
            return this;
        }
        public Builder customerId(Long customerId)
        {
            this.customerId=customerId;
            return  this;
        }
        public Builder shippingAddressId(Long shippingAddressId)
        {
            this.shippingAddressId=shippingAddressId;
            return this;
        }

        public Builder  billingAddressId(Long billingAddressId)
        {
            this.billingAddressId=billingAddressId;
            return this;
        }

        public Builder orderDate(Date orderDate ){
            this.orderDate=orderDate;
            return this;
        }
        public Builder shippingDate(Date shippingDate)
        {
            this.shippingDate=shippingDate;
            return this;
        }
        public Builder orderamount(double orderAmount)
        {
            this.orderAmount=orderAmount;
            return this;
        }
        public Builder discount(double discount){
            this.discount=discount;
            return this;
        }
        public Builder shippingAmount(double shippingAmount)
        {
            this.shippingAmount=shippingAmount;
            return this;
        }
        public Builder taxAmount(double taxAmount)
        {
            this.taxAmount=taxAmount;
            return this;
        }


        public Builder netAmount(double netAmount)
        {
            this.netAmount=netAmount;
            return this;
        }




        public Builder copy(OrderResource value) {
            this.orderId=value.getOrderId();
            this.customerId=value.getCustomerId();
            this.billingAddressId=value.getBillingAddressId();
            this.shippingAddressId=value.getShippingAddresId();
            this.orderDate=value.getOrderDate();
            this.shippingDate=value.getShippingDate();
            this.orderAmount=value.getOrderAmount();
            this.discount=value.getDiscount();
            this.shippingAmount=value.getShippingAmount();
            this.taxAmount=value.getTaxAmount();
            this.netAmount=value.getNetAmount();




            return this;

        }
        public OrderResource build()
        {
            return new OrderResource(this);
        }


    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getShippingAddresId() {
        return shippingAddresId;
    }

    public Long getBillingAddressId() {
        return billingAddressId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getShippingAmount() {
        return shippingAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderResource other = (OrderResource) obj;
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Oder id{" + ":" + orderId+ '}';
    }
}
