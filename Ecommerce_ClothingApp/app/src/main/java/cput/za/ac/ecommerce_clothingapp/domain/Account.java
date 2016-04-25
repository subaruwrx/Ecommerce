package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Admin on 2016-04-19.
 */
public class Account implements Serializable {

    private Long id;
    private String accountNumber;
    private Address address;
    private String is_closed;
    private Date open;
    private Date closed;

    private Account(){

    }

    private Account(Builder build){
        id=build.id;
        accountNumber=build.accountNumber;
        address=build.address;
        is_closed=build.is_closed;
        open=build.open;
        closed=build.closed;


    }

    public static class Builder{

        private Long id;
        private String accountNumber;
        private Address address;
        private String is_closed;
        private Date open;
        private Date closed;

        public Builder(){

        }

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder accountNumber(String accountNumber){
            this.accountNumber=accountNumber;
            return this;
        }

        public Builder addressAccount(Address address){
            this.address=address;
            return this;
        }


        public Builder is_Closed(String is_closed){
            this.is_closed=is_closed;
            return this;
        }

        public Builder open(Date open){
            this.open=open;
            return this;
        }

        public Builder closed(Date closed){
            this.closed=closed;
            return this;
        }

        public Builder copy(Account value)
        {

            this.id=value.getId();
            this.accountNumber=value.getAccountNumber();
            this.address=value.getAddress();
            this.open=value.getOpen();
            this.closed=value.getClosed();
            this.is_closed=value.is_closed();

            return this;
        }

        public Account build()
        {
            return new Account(this);
        }


    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public Date getOpen() {
        return open;
    }

    public String is_closed() {
        return is_closed;
    }

    public Date getClosed() {
        return closed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account {" + "id=" + id + '}';
    }
}
