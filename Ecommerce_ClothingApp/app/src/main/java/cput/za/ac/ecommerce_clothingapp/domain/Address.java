package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-04-19.
 */
public class Address implements Serializable {

    private String city;
    private String street;
    private String country;

    public Address() {

    }

    private Address(Builder build) {
        this.city = build.city;
        this.street = build.street;
        this.country = build.country;

    }

    public static class Builder {

        private String city;
        private String street;
        private String country;

        public Builder(String city) {
            this.city = city;

        }

        public Builder Street(String street) {
            this.street = street;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder copy(Address address) {
            city = address.getCity();
            street = address.getStreet();
            country = address.getCountry();
            return this;

        }

        public Address build() {
            return new Address(this);
        }

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

