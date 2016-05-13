package cput.za.ac.ecommerce_clothingapp.restapi.resources;


import java.io.Serializable;

/**
 * Created by Admin on 2016-04-07.
 */
public class ProductResource implements Serializable{
    private long id;
    private String prodName;
    private String prodtype;
    private double originalPrice;
    private double salePrice;
    private long categoryId;
    private long typeId;
    private int prodquantity;
    private String description;
    private long ratingId;
    private byte[] image;



    private ProductResource()
    {
    }

    public ProductResource(Builder build)
    {
       this.id=build.id;
       this.prodName=build.prodName;
       this.prodtype=build.prodtype;
       this.prodquantity=build.prodquantity;
       this.image=build.image;
       this.ratingId=build.ratingId;
       this.description=build.description;
       this.typeId=build.typeId;this.categoryId=build.categoryId;
       this.salePrice=build.salePrice;
       this.originalPrice=build.originalPrice;


    }



    public static class Builder{

        private long id;
        private String prodName;
        private String prodtype;
        private double originalPrice;
        private double salePrice;
        private long categoryId;
        private long typeId;
        private int prodquantity;
        private String description;
        private long ratingId;
        private byte[] image;

        public Builder () {

        }
        public Builder id(long id) {

            this.id = id;
            return this;
        }
        public Builder image( byte[] image)
        {
            this.image=image;
            return this;
        }

        public Builder ratingId(long ratingId)
        {
            this.ratingId=ratingId;
            return this;
        }
        public Builder description(String description)
        {
            this.description=description;
            return this;
        }

        public Builder typeId(long typeId)
        {
            this.typeId=typeId;
            return this;
        }
        public Builder categoryId(long categoryId)
        {
            this.categoryId=categoryId;
            return this;
        }
        public Builder salePrice(double salePrice)
        {
            this.salePrice=salePrice;
            return this;
        }

        public Builder productName(String prodName){
            this.prodName= prodName;
            return this ;
        }

        public Builder productType(String prodtype){
            this.prodtype= prodtype;
            return this;
        }

        public Builder productQuantity(int prodquantity){
            this.prodquantity= prodquantity;
            return this;

        }

        public Builder originalPrice( double originalPrice){
            this.originalPrice=originalPrice;
            return this;
        }


        public Builder copy(ProductResource value)
        {

            this.id = value.getId();
            this.prodName =value.getProdName();
            this.prodtype = value.getProdtype();
            this.prodquantity= value.getProdquantity();
            this.originalPrice=value.getOriginalPrice();
            this.image=value.getImage();
            this.ratingId=value.getRatingId();
            this.description=value.getDescription();
            this.categoryId=value.getCategoryId();
            this.salePrice=value.getSalePrice();
            this.originalPrice=value.getOriginalPrice();
            this.typeId=value.getTypeId();

            return this;
        }


        public ProductResource build()
        {
            return new ProductResource(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdtype() {
        return prodtype;
    }


    public byte[] getImage() {
        return image;
    }

    public long getRatingId() {
        return ratingId;
    }

    public String getDescription() {
        return description;
    }

    public long getTypeId() {
        return typeId;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }


    public int getProdquantity() {
        return prodquantity;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + id + '}';
    }
}
