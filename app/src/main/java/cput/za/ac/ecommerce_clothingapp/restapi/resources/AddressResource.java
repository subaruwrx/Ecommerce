package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;

/**
 * Created by Admin on 2016-04-11.
 */
public class AddressResource implements Serializable {

    private Long id;
    private String city;
    private String street;
    private String country;
    private String zipCode;



    private AddressResource() {

    }

    public AddressResource(Builder build) {
        this.id = build.id;
        this.zipCode = build.zipCode;
        this.city = build.city;
        this.street = build.street;
        this.country = build.country;

    }

    public static class Builder {

        private Long id;
        private String city;
        private String street;
        private String country;
        private String zipCode;

        public Builder() {

        }
        public Builder city(String city) {
            this.city = city;
            return this;

        }

        public Builder id(Long id)
        {
            this.id=id;
            return  this;
        }

        public Builder zipCode(String zipCode)
        {
            this.zipCode=zipCode;
            return this;
        }
        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder copy(AddressResource address) {
            this.id=address.getId();
            this.zipCode=address.getZipCode();
            this.city = address.getCity();
            this.street = address.getStreet();
            this.country = address.getCountry();
            return this;

        }

        public AddressResource build() {
            return new AddressResource(this);
        }

    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }
    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }



    @Override
    public String toString()
    {
        return String.format("city: " +city + "Street name: " +street + "Country: "+ country);
    }

}
