package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;

import cput.za.ac.ecommerce_clothingapp.domain.UserAccount;

/**
 * Created by Admin on 2016-05-02.
 */
public class RoleResource implements Serializable{
    private Long id;
    private String role;
    private String description;
    private UserAccount user;

    private RoleResource(){}

    public RoleResource(Builder build)
    {
        this.id=build.id;
        this.role=build.role;
        this.description=build.description;

    }

    public static class Builder{
        private Long id;
        private String role;
        private String description;

        public Builder()
        {}

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder role(String role){
            this.role=role;
            return this;
        }
        public Builder description(String description)
        {
            this.description=description;
            return this;
        }

        public Builder copy(RoleResource values){
            this.id=values.getId();
            this.role=values.getRole();
            this.description=values.getDescription();
            return this;
        }

        public RoleResource build(){return new RoleResource(this);}
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }
}
