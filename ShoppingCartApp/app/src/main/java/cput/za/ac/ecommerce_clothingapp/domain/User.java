package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2016-05-02.
 */
public class User implements Serializable {
    private Long userId;
    private Long accountId;
    private Long addressId;
    private String firstName;
    private String surName;
    private String contactNo;
    private String gender;
    private String email;
    private String description;
    private List<Order> order;

    private User(){}

    public User(Builder build)
    {
        this.userId=build.userId;
        this.accountId=build.accountId;
        this.addressId=build.addressId;
        this.firstName=build.firstName;
        this.surName=build.surName;
        this.contactNo=build.contactNo;
        this.gender=build.gender;
        this.email=build.email;
        this.description=build.description;

    }

    public static class Builder{

        private Long userId;
        private Long accountId;
        private Long addressId;
        private String firstName;
        private String surName;
        private String contactNo;
        private String gender;
        private String email;
        private String description;

        public Builder(){}

        public Builder userId(Long userId)
        {
            this.userId=userId;
            return this;
        }

        public Builder accountId(Long accountId){
            this.accountId=accountId;
            return this;
        }

        public Builder addressId(Long addressId){
            this.addressId=addressId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder surName(String surName){
            this.surName=surName;
            return this;
        }

        public Builder contactNo(String contactNo)
        {
            this.contactNo=contactNo;
            return this;
        }

        public Builder gender(String gender)
        {
            this.gender=gender;
            return this;
        }

        public Builder email(String email)
        {
            this.email=email;
            return this;
        }

        public Builder  description(String description){
            this.description=description;
            return this;
        }

        public Builder copy(User user)
        {
            this.userId=user.getUserId();
            this.accountId=user.getAccountId();
            this.addressId=user.getAddressId();
            this.firstName=user.getFirstName();
            this.surName=user.getSurName();
            this.gender=user.getGender();
            this.contactNo=user.getContactNo();
            this.email=user.getEmail();
            this.description=user.getDescription();
            return  this;
        }

        public User build(){return new User(this);}
    }


    public Long getUserId() {
        return userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
