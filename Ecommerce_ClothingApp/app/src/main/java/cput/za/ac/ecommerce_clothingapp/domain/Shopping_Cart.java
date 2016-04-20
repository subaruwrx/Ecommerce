package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Admin on 2016-04-20.
 */
public class Shopping_Cart implements Serializable {

    private Long id;
    private Date created;

    private Shopping_Cart(){}

    private Shopping_Cart(Builder build){
        this.id=build.id;
        this.created=build.created;

    }

    public static class Builder{
        private Long id;
        private Date created;

        public Builder(Long id){
            this.id=id;
        }

        public Builder dateCreated(Date created)
        {
            this.created=created;
            return this;
        }

        public Builder copy(Shopping_Cart value)
        {

            this.id=value.getId();
            this.created=value.getCreated();


            return this;
        }

        public Shopping_Cart build()
        {
            return new Shopping_Cart(this);
        }

    }

    public Long getId() {
        return id;
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
        final Shopping_Cart other = ( Shopping_Cart ) obj;
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

