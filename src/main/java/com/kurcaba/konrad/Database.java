/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kurcaba.konrad;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Konrad
 */
public class Database {
    static final Map<String, Product> database = new HashMap<String, Product>();

    static
    {
       database.put("1", new Product("Szampon",new BigDecimal("5.60")));
       database.put("2", new Product("Krem",new BigDecimal("10.50")));
       database.put("3", new Product("Pasta",new BigDecimal("1.50")));
    }
    
    public static Product getProduct(String code) throws SQLException
    {
        Product product;
        product = database.get(code);
        if(product == null) throw new SQLException("Product not found");
        else return product;
    }
   
    
}
