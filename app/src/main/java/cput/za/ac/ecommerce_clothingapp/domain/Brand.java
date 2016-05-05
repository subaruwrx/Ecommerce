package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 2016-04-13.
 */
public class Brand implements Serializable {
    private Long id;
    private String brandName;
    private byte[] logo;
    private List<Product> products;


    private Brand(){

    }

    public Brand(Builder build ){
        this.id=build.id;
        this.brandName=build.brandName;
        this.logo=build.logo;


    }

    public static  class Builder{
        private Long id;
        private String brandName;
        private byte[] logo;


        public Builder()
        {

        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }


        public Builder logo( byte[] logo){
            this.logo=logo;
            return  this;
        }

        public Builder brandName(String brandName){
            this.brandName=brandName;
            return this;

        }

        public Builder copy(Brand value)
        {
            this.id=value.getId();
            this.logo=value.getLogo();
            this.brandName=value.getBrandName();

            return this;
        }

        public Brand build()
        {
            return new Brand(this);
        }

    }


    public Long getId() {
        return id;
    }

    public byte[] getLogo() {
        return logo;
    }

    public String getBrandName() {
        return brandName;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Brand other = ( Brand ) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Brand id{" + ":" + id+ '}';
    }
}
