package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class mysql {
                    String url = "jdbc:mysql://localhost:3306/userspdf";
                    String username = "root";
            public boolean conMysql(){
                
                     String password = "Esoterismo2001";
                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        System.out.println("Conexión exitosa a la base de datos");
          
                    // A partir de aquí, puedes llevar a cabo operaciones en la base de datos utilizando la conexión
                            ventana v1 = new ventana();
                        boolean r = consultar(connection, v1.getField(), v1.getField1());


                        connection.close();
                        return r;
                        } catch (SQLException e) {
                            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                        }
                        return false;
                    }

            public boolean consultar(Connection connection, String username, String contra) throws SQLException{

                 Statement statement = connection.createStatement();
                 String sql = "SELECT * FROM usuarios where usuario = '"+username+"' and contraseña = '"+contra+"';";
                ResultSet resultSet = statement.executeQuery(sql);
                
      
             statement = connection.prepareStatement(sql);
             ((PreparedStatement) statement).setString(1, username);
             ((PreparedStatement) statement).setString(2, contra);
                if (resultSet.next()) {
                    System.out.println("Usuario autenticado");
                    resultSet.close();
                    statement.close();
                    return true;
                } else {
                    System.out.println("Credenciales incorrectas");
              }
                resultSet.close();
                statement.close();
                return false;
            }
                }
    
      
