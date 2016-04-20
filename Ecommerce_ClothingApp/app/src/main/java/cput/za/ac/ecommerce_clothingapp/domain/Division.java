package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Admin on 2016-04-20.
 */
public class Division implements Serializable {

    private Address address;
    private String warehouse;
    private String productType;

    public  Division()
    {

    }

    public Division(Builder build)
    {
        address=build.address;
        warehouse=build.warehouse;
        productType=build.productType;

    }

    public static class Builder{

        private Address address;
        private String warehouse;
        private String productType;

        public Builder(String warehouse)
        {
            this.warehouse=warehouse;
        }

        public Builder Street(Address address) {
            this.address = address;
            return this;
        }

        public Builder producttypewhareH(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder copy(Division value) {
            this.address=value.getAddress();
            this.warehouse=value.getWarehouse();
            this.productType=value.getProductType();

            return this;

        }
        public Division build()
        {
            return new Division(this);
        }

    }




    public Address getAddress() {
        return address;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public String getProductType() {
        return productType;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Division other = (Division) obj;
        if (!Objects.equals(this.warehouse, other.warehouse)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Divion{" + ":" + warehouse + '}';
    }

}

