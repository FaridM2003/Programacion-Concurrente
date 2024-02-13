package com.project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class mysql {
    public void conectar(){
    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ventana v1 =new ventana();
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE usuario = "+v1.getField()+"");
            preparedStatement.setString(1, "john.doe");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("User exists in the database.");
            } else {
                System.out.println("User does not exist in the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }         
}
        
    
      

