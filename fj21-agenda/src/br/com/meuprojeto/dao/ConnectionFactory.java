package br.com.meuprojeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	Connection con;  
    PreparedStatement stmt;  
    ResultSet rs; 
	
	public Connection open() throws SQLException, Exception{
		try {
			Class.forName("org.postgresql.Driver");  
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Database_teste", "postgres", "123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
		return con;
	}
	
	public void close() throws Exception{  
        
        try {  
            con.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
    }
}
