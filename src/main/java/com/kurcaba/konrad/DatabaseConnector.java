/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kurcaba.konrad;

import java.sql.SQLException;
import javax.swing.SwingWorker;

/**
 *
 * @author Konrad
 */
public class DatabaseConnector extends SwingWorker<Void,Object> {

    String code;
    Product product;
    String error_message;
    public DatabaseConnector(String code) {
        this.code = code;
    }
    
    @Override
    protected Void doInBackground()  {
        
        try
        {
        product = Database.getProduct(code);
    
        }catch(SQLException e)
        {
            error_message = e.getMessage();
        }
        catch(Exception e)
        {
            error_message = e.getMessage();
        }
        return null;
    }

    @Override
    protected void done() {
        
        if(product != null)
        {
            Main.showProductOnDisplay(product);
        }
        else
        {
            Main.showNotFoundOnDisplay();
        }
        
    }
        
    
}
