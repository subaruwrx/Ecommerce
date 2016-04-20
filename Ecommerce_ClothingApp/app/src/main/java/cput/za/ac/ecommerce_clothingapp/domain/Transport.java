package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-04-20.
 */
public class Transport implements Serializable {

    private String id;
    private String transportType;
    private String location;
    private String available;
    private String root;

    private Transport(){

    }

    private  Transport(Builder build)
    {
        id=build.id;
        transportType=build.transportType;
        location=build.location;
        available=build.available;
        root=build.root;

    }
    public static class Builder{

        private String id;
        private String transportType;
        private String location;
        private String available;
        private String root;

        public Builder(String id)
        {
            this.id=id;
        }

        public Builder transportType(String transportType)
        {
            this.transportType=transportType;
            return this;

        }

        public Builder locationMethod(String location){
            this.location=location;
            return  this;
        }

        public Builder rootMethod(String root){
            this.root=root;
            return this;
        }

        public Builder availableMethod(String available)
        {
            this.available=available;
            return this;

        }


        public Builder copy(Transport value)
        {
            this.id=value.getId();
            this.transportType=value.getTransportType();
            this.location=value.getLocation();
            this.available=value.getAvailable();


            return this;
        }

        public Transport build(){return new Transport(this);}
    }

    public String getId() {
        return id;
    }

    public String getTransportType() {
        return transportType;
    }

    public String getLocation() {
        return location;
    }

    public String getAvailable() {
        return available;
    }

    public String getRoot() {
        return root;
    }
    @Override
    public String toString() {
        return "TransportId{" + "id=" + id + '}';
    }
}
