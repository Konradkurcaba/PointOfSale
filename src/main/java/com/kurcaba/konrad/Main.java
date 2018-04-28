/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kurcaba.konrad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Konrad
 */
public class Main {
    
    
    static Scanner scanner;
    static Display display;
    static List<Product> productList = new ArrayList<Product>();
    
    static void checkInDatabase(String code)
    {
        if(!code.isEmpty())
        {
            if(code.equals("exit"))
            {
                printAllProducts();
            }
            else
            {
                DatabaseConnector connector = new DatabaseConnector(code);
                connector.execute();
            }
        
        }
        else
        {
            showInvalidBarCodeOnDisplay();
        }
    }
    
    static void showProductOnDisplay(Product product)
    {
        display.addItem(product);
        productList.add(product);
    }
    
    static void showNotFoundOnDisplay()
    {
        display.productNotFound();
    }
    
    static void showInvalidBarCodeOnDisplay()
    {
        display.invalidBarCode();
    }
    
    static void printAllProducts()
    {
        StringBuilder builder = new StringBuilder();
        BigDecimal totalSum = new BigDecimal("0");
        for(Product product : productList)
        {
            builder.append(String.format("%-20s %8s\n",product.getName(),product.getPrice().toString()));
            totalSum = totalSum.add(product.getPrice());
        }
        builder.append(String.format("%-20s %8s","Total sum:",totalSum.toString()));
        Printer printer = new Printer(builder.toString());
        display.showTotalSum(totalSum.toString());
        
        
    }
    public static void main(String[] args)
    {
        display = new Display();
        display.setVisible(true);
        
        scanner = new Scanner();
        scanner.setVisible(true);
    
        
    }
   
}
