/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apitutorial;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ApiTutorial {

    public static void main(String[] args) throws SQLException {
        MySql mysql = new MySql();
        
        ResultSet offices = (ResultSet) mysql.getAllData("offices").get("data");
        while(offices.next()) {
            System.out.println(offices.getObject("city"));
        }
    }
}
