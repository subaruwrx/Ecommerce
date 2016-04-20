package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Admin on 2016-04-20.
 */
public class Supplier implements Serializable {
    private Long id;

    private String name;
    private String companyName;
    private String supplyingType;

    private Supplier() {

    }

    private Supplier(Builder build) {
        companyName = build.companyName;
        supplyingType = build.supplyingType;
        name = build.name;
        id = build.id;

    }

    public static class Builder {

        private Long id;
        private String name;
        private String companyName;
        private String supplyingType;

        public Builder() {

        }

        public Builder Id(Long id) {
            this.id = id;
            return this;
        }

        public Builder supplyingType(String supplyingType) {
            this.supplyingType = supplyingType;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder copy(Supplier sup)
        {
            this.companyName = sup.companyName;
            this.id = sup.id;
            this.supplyingType = sup.supplyingType;
            this.name = sup.name;
            return this;
        }

        public Supplier build()
        {
            return new Supplier(this);
        }

    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSupplyingType() {
        return supplyingType;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supplier other = (Supplier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + '}';
    }

}
