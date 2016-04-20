package cput.za.ac.ecommerce_clothingapp.domain;

import java.util.Objects;

/**
 * Created by Admin on 2016-04-19.
 */
public class Customer  {

    private Long Id;

    private String custNumber;
    private String custName;
    private String custSurname;
    private Address address;


    private Customer() {
    }


    private Customer(Builder build)
    {
        Id = build.Id;
        custName = build.custName;
        custSurname = build.custSurname;
        custNumber = build.custNumber;
        address = build.address;

    }


    public static class Builder{

        private Long Id;
        private String custName;
        private String custNumber;
        private String custSurname;
        private Address address;

        public Builder () {

        }
        public Builder custNumber(String custNumber){
            this.custNumber = custNumber;
            return this;
        }

        public Builder Address (Address addr){
            this.address = addr;
            return this;
        }
        public Builder id(Long id) {
            this.Id = id;
            return this;
        }

        public Builder custName(String custName) {
            this.custName = custName;
            return this;
        }

        public Builder custSurname(String custSurname) {
            this.custSurname = custSurname;
            return this;
        }


        public Builder copy(Customer cust)
        {

            custName = cust.getCustName();
            custNumber = cust.getCustNumber();
            custSurname = cust.getCustSurname();
            address=cust.getAddress();
            Id = cust.getID();
            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }
    }


    public Long getID()
    {
        return Id;
    }
    public String getCustName() {
        return custName;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public String getCustSurname() {
        return custSurname;
    }

    public Address getAddress(){return address;}



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "Id=" + Id + '}';
    }



}
