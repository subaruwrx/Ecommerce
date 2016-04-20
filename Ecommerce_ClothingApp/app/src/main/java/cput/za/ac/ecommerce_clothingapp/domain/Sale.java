package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-04-20.
 */
public class Sale implements Serializable {

    private String saleDocumentNum;
    private int invoiceNumber;
    private int numOfItems;
    private String orderstatus;
    private String creditType;
    private int quantity;

    private Sale(){

    }

    private Sale(Builder build)
    {
        saleDocumentNum=build.saleDocumentNum;
        invoiceNumber=build.invoiceNumber;
        numOfItems=build.numOfItems;
        orderstatus=build.orderstatus;
        creditType=build.creditType;
        quantity=build.quantity;


    }

    public static class Builder{

        private String saleDocumentNum;
        private int invoiceNumber;
        private int numOfItems;
        private String orderstatus;
        private String creditType;
        private int quantity;


        public Builder(){

        }

        public Builder documentNumber(String saleDocumentNum)
        {
            this.saleDocumentNum=saleDocumentNum;
            return this;
        }

        public Builder invoiceNumber(int invoiceNumber){
            this.invoiceNumber=invoiceNumber;
            return this;
        }

        public Builder numOfItems(int numOfItems){
            this.numOfItems=numOfItems;
            return this;
        }
        public Builder orderStatus(String orderstatus){
            this.orderstatus=orderstatus;
            return this;
        }

        public Builder creditType(String creditType)
        {
            this.creditType=creditType;
            return this;
        }

        public Builder quantity(int quantity)
        {
            this.quantity=quantity;
            return this;
        }

        public Builder copy(Sale value)
        {

            this.saleDocumentNum=value.getSaleDocumentNum();
            this.invoiceNumber =value.getInvoiceNumber();
            this.numOfItems = value.getNumOfItems();
            this.orderstatus = value.getOrderstatus();
            this.creditType= value.getCreditType();
            this.quantity=value.getQuantity();

            return this;
        }


        public Sale build(){return new Sale(this);}


    }

    public String getSaleDocumentNum() {
        return saleDocumentNum;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public String getCreditType() {
        return creditType;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "sale Document Number: " + "Id=" + saleDocumentNum ;
    }
}

