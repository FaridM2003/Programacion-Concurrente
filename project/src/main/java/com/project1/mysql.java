package com.project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class mysql {
    public void conectar(){
        ventana v1 =new ventana();
        try{    
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/usuario","root","");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from usuarios where usuario='"+v1.getField()+"' and contra='"+v1.getField1()+"'");  
            while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(5)+" "+rs.getString(6));  
            con.close();  
            }catch(Exception e){ System.out.println(e);}  
            }  
        }
      
        
    
      

