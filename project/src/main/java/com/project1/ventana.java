package com.project1;

import java.awt.Color;
import javax.swing.*;

import javax.swing.event.*;
    
    public class ventana extends JFrame{
        
        JTextField TextF1 = new JTextField();
        JPasswordField TextF2 = new JPasswordField();
            public String getField(){
                return TextF1.getText();
            }
            public String getField1(){
                char[] charArray = TextF2.getPassword();
                String textoPass = new String(charArray);
                return textoPass;
            }


            public ventana(){
                this.setSize(550,200);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("Convertidor de archivo PNG a PDF");
                setLocation(WIDTH, HEIGHT);
               
                this.iniciar();
            }

            public void iniciar(){
                    //Variables
                    menuPDF ventana2 = new menuPDF();
                    //paneless
                    JPanel pane = new JPanel();
                    pane.setLayout(null);
                    pane.setBackground(Color.GRAY);
                    this.getContentPane().add(pane);
            
 
                    //etiquetas
                    JLabel etiqueta1 = new JLabel("Nombre de usuario");
                    JLabel etiqueta2 = new JLabel("Contraseña");
                    etiqueta1.setBounds(10, 10, 200, 30);
                    etiqueta2.setBounds(250, 10 , 200, 30);
                    etiqueta1.setForeground(Color.white);
                    etiqueta2.setForeground(Color.white);
                    pane.add(etiqueta1);
                    pane.add(etiqueta2);
                    //caja de texto
                    TextF1.setBounds(10,50,200,20);
                    TextF2.setBounds(250,50,200,20);
                    pane.add(TextF1);
                    pane.add(TextF2);
                    //botones
              JButton button1 = new JButton();
                    button1.setText("Aceptar");
                    button1.setBounds(400,100,100,20);
                    button1.setEnabled(false);
                    pane.add(button1);
              
                    //Funciones complejas
                   DocumentListener documentListener = new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                            changed();
                        }
                    public void removeUpdate(DocumentEvent e) {
                        changed();
                        }
                    public void insertUpdate(DocumentEvent e) {
                        changed();
                        }
                    public void changed() {
                        if (TextF1.getText().length() > 0 && TextF2.getPassword().length > 0) 
                            button1.setEnabled(true);// Habilitar el botón
                         else button1.setEnabled(false);// Deshabilitar el botón
                        
                        }
                    };
                        TextF1.getDocument().addDocumentListener(documentListener);
                        TextF2.getDocument().addDocumentListener(documentListener);
                        
                        //boton para acceder la base de datos
                        button1.addActionListener(e -> {
                            mysql ventanaSQL = new mysql();
                            ventanaSQL.conectar();
                            // Cierra solo la ventana actual, no termina la aplicación
                            ventana2.setVisible(true);
                            this.setVisible(false);
                            });
            }

    }
