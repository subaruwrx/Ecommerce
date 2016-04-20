package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Admin on 2016-04-20.
 */
public class Brand implements Serializable {
    private Long id;
    private String brandCode;
    private String brandName;

    private  Brand(){

    }

    private  Brand(Builder build ){
        this.id=build.id;
        this.brandCode=build.brandCode;
        this.brandName=build.brandName;


    }

    public static  class Builder{
        private Long id;
        private String brandCode;
        private String brandName;

        public Builder()
        {

        }
        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }

        public Builder brandCode(String brandCode){
            this.brandCode=brandCode;
            return  this;
        }

        public Builder brandName(String brandName){
            this.brandName=brandName;
            return this;

        }

        public Builder copy(Brand value)
        {
            this.id=value.getId();
            this.brandCode=value.getBrandCode();
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

    public String getBrandCode() {
        return brandCode;
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
