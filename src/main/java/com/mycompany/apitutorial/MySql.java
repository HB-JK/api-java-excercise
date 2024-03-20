/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apitutorial;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class MySql {
    protected Connection connect = null;
    protected PreparedStatement prepared_statement = null;
    protected Statement statement = null;
    protected HashMap<String, Object> response = new HashMap<>();
    
    public MySql () {
        this.connect();
    }
    
    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuliah_retail", "root", "blazing12");
            statement = connect.createStatement();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public HashMap getAllData(String table_name) {
        response.clear();
        
        try {
            ResultSet result_set = statement.executeQuery("SELECT * FROM " + table_name);
            
            response.put("data", result_set);
            response.put("status", 200);
            return response;
        } catch (SQLException e) {
            response.put("status", 422);
            response.put("message", e);
            return response;
        }
    }
    
    public HashMap findData(String table_name, int id) {
        response.clear();
        
        try {
            ResultSet result_set = statement.executeQuery("SELECT * FROM " + table_name + " WHERE id=" + id);
            
            response.put("data", result_set);
            response.put("status", 200);
            return response;
        } catch (SQLException e) {
            response.put("status", 422);
            response.put("message", e);
            return response;
        }
    }
    
}
