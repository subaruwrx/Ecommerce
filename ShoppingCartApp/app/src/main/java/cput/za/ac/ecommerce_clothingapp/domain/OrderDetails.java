package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2016-05-02.
 */
public class OrderDetails implements Serializable {

    private Long orderId;
    private Long productId;
    private double productPrice;
    private double discount;
    private  int quantity;
    private Order order;
    private Product  product;
    private OrderDetails(){}

    public OrderDetails(Builder build){

        this.orderId=build.orderId;
        this.productId=build.productId;
        this.productPrice=build.productPrice;
        this.discount=build.discount;
        this.quantity=build.quantity;
    }

    public static class Builder{
        private Long orderId;
        private Long productId;
        private double productPrice;
        private double discount;
        private  int quantity;

        public Builder(){}
        public Builder orderId(Long productId)
        {
            this.productId=productId;
            return this;
        }

        public Builder productId(Long productId)
        {
            this.productId=productId;
            return  this;
        }

        public Builder productPrice(double productPrice)
        {
            this.productPrice=productPrice;
            return this;
        }
        public Builder discount(double discount)
        {
            this.discount=discount;
            return this;

        }
        public Builder quantity(int quantity)
        {
            this.quantity=quantity;
            return this;
        }

        public Builder copy(OrderDetails details)
        {
            this.productId=details.getProductId();
            this.orderId=details.getOrderId();
            this.discount=details.getDiscount();
            this.productPrice=details.getProductPrice();
            this.quantity=details.getQuantity();

            return this;
        }

        public OrderDetails build(){return  new OrderDetails(this);}

    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }
}
