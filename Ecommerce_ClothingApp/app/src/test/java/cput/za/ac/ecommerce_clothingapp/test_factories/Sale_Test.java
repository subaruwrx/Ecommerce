package cput.za.ac.ecommerce_clothingapp.test_factories;

import junit.framework.Assert;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cput.za.ac.ecommerce_clothingapp.domain.Sale;
import cput.za.ac.ecommerce_clothingapp.factories.Sale_Factory;

/**
 * Created by Admin on 2016-04-20.
 */
public class Sale_Test {

    @Test
    public void testCreateSale() throws Exception {
        final int number=101;
        final int quan=10;
        Map<String,String> values = new HashMap<>();
        Map<String,Integer> num=new HashMap<>();

        num.put("invoiceNumber",number);
        num.put("quauntity",quan);

        values.put("saleDocumentNum","Nik0982");
        values.put("orderstatus", "yes");
        values.put("creditType","laybuy");


        Sale sale = Sale_Factory
                .createSales(values,num);

        Assert.assertEquals(number,sale.getInvoiceNumber() );
        Assert.assertEquals(quan,sale.getQuantity());
        Assert.assertEquals("Nik0982",sale.getSaleDocumentNum());
    }


    @Test
    public void testUpdateSale() throws Exception {


        final int number=102;
        final int quan=12;
        Map<String,String> values = new HashMap<>();
        Map<String,Integer> num=new HashMap<>();

        num.put("invoiceNumber",101);
        num.put("quauntity",10);

        values.put("saleDocumentNum","Nik0982");
        values.put("orderstatus", "done");
        values.put("creditType","laybuy");


        Sale sale = Sale_Factory
                .createSales(values,num);

        Sale sale1= new Sale
                .Builder()
                .copy(sale)
                .invoiceNumber(number)
                .documentNumber("Add0982")
                .creditType("cash")
                .numOfItems(quan)
                .orderStatus("processing")
                .build();
        Assert.assertEquals(number, sale1.getInvoiceNumber());
        Assert.assertEquals("Add0982",sale1.getSaleDocumentNum());


    }





}
