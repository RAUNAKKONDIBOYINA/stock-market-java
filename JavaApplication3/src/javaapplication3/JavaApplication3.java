/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author dell
 */
import java.sql.*;
import java.util.*;
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_exchange","root","");
                
		PreparedStatement statement=con.prepareStatement("select * from msft");
		
		ResultSet result=statement.executeQuery();
		 
		while(result.next())
		{
			System.out.println(result.getString(2));// + " " + result.getString(2));
		}
    }
    
    
}
