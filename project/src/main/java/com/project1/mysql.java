package com.project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class mysql {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/usuarios";
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public String obtenerTipoUsuario( String usuario) throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "SELECT * FROM `usuarios-uplc`,`tipo-categorias` WHERE `usuarios-uplc`.usuario = '"+usuario+"' and `tipo-categorias`.id = `usuarios-uplc`.`categorias_id`" ; // Suponiendo que el usuario con ID 1 es el usuario actual
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("categoria");
        }
        return "usuario"; // Si no se encuentra el tipo de usuario, devolver un valor por defecto
    }




    public void start(String[] args, String usuario, String Password) {
       
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `usuarios-uplc` WHERE usuario = '" + usuario + "' AND contrasenia = '" + Password + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Inicio de sesión exitoso!");
                JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
                menuPDF s = new menuPDF();
                s.AgregarUsuario(usuario);
                s.setVisible(true);
            } else {
                System.out.println("Credenciales inválidas. Inicio de sesión fallido.");
                JOptionPane.showMessageDialog(null, "Credenciales Invalidas");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
        }
      
        
    
      

