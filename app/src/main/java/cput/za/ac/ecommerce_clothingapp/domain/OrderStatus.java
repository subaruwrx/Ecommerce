package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-05-02.
 */
public class OrderStatus implements Serializable{
    private Long id;
    private String name;
    private String description;
    private Order order;

    private OrderStatus(){


    }

    public OrderStatus(Builder build)
    {
        this.id=build.id;
        this.name=build.name;
        this.description=build.description;

    }

    public static class Builder{
        private Long id;
        private String name;
        private String description;

        public Builder()
        {

        }
        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }

        public Builder name(String name)
        {
            this.name=name;
            return this;
        }

        public Builder description(String description)
        {
            this.description=description;
            return this;
        }

        public Builder copy(OrderStatus status)
        {
            this.id=status.getId();
            this.name=status.getName();
            this.description=status.getDescription();
            return this;
        }

        public OrderStatus build(){return new OrderStatus(this);}
    }
    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }




}
