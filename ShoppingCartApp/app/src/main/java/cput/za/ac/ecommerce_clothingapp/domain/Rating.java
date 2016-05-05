package cput.za.ac.ecommerce_clothingapp.domain;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2016-04-29.
 */
public class Rating implements Serializable {

    private long id;
    private String name;
    private byte[] image;
    private String description;
    private List<Product > product;






    private Rating(){

    }
    public Rating(Builder build){
        this.id=build.id;
        this.name=build.name;
        this.image=build.image;
        this.description=build.description;

    }

    public static class Builder{
        private long id;
        private String name;
        private byte[] image;
        private String description;

        public Builder()
        {

        }

        public Builder id(long id)
        {
            this.id=id;
            return  this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder image(byte [] image)
        {
            this.image=image;
            return this;
        }

        public Builder description(String description)
        {
            this.description=description;
            return this;
        }

        public Builder copy(Rating value)
        {
            this.id=value.getId();
            this.name=value.getName();
            this.description=value.getDescription();
            this.image=value.getImage();
            return this;
        }

        public Rating build(){return new Rating(this);}

    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }



}
