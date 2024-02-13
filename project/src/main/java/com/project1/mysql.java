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
                    String url = "jdbc:mysql://localhost:3306/userspdf";
                    String username = "root";
            public boolean conMysql(){
                
                     String password = "";
                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        System.out.println("Conexión exitosa a la base de datos");
          
                    // A partir de aquí, puedes llevar a cabo operaciones en la base de datos utilizando la conexión
                            ventana v1 = new ventana();
                        Statement statement = connection.createStatement();
                        String sql = "SELECT * FROM usuarios where usuario ="+v1.getField()+"' and contraseña ='"+v1.getField1()+"';";
                       ResultSet resultSet = statement.executeQuery(sql);
                       statement = connection.prepareStatement(sql);

                       ((PreparedStatement) statement).setString(1, v1.getField());
                       ((PreparedStatement) statement).setString(2, v1.getField1());
                       if (resultSet.next()) {
                        System.out.println("Usuario autenticado");
                        resultSet.close();
                        statement.close();
                        } else {
                         System.out.println("Credenciales incorrectas");
                        }
                            resultSet.close();
                            statement.close();





                        connection.close();
                        return true;
                        } catch (SQLException e) {
                            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                        }
                        return false;
                    }

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
        
    
      

