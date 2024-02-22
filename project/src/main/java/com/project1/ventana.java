package com.project1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
    
    public class ventana extends JFrame{
        String usuarioalmacen;
        JTextField UsuarioTexto = new  JTextField();
        private JPasswordField contra = new  JPasswordField(10);
            public String getField(){
                return usuarioalmacen;
            }
            public String getField1(){
                char[] charArray = contra.getPassword();
                String textoPass = new String(charArray);
                return textoPass;
            }


            ImageIcon imagen1 = new ImageIcon("images/background1.jpeg");
            public ventana(){
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    System.out.println("Error al establecer el look and feel: " + e);
                }
                setSize(600,600);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("Convertidor de archivo PNG a PDF");
                setLocationRelativeTo(null);
                setResizable(false);
                setLayout(new GridLayout(1, 1));
                java.awt.Image image = imagen1.getImage();
                Image image1 = image.getScaledInstance(getWidth(), getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImageIcon = new ImageIcon(image1);
                    JLabel background = new JLabel(newImageIcon, JLabel.CENTER);
                    add(background);
                this.iniciar();
            }

            public void iniciar(){
                JPanel p1 = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(new Color(11, 14, 21)); // Establecer el color de fondo con opacidad
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }};
                    p1.setOpaque(false);
                    p1.setLayout(null);
                    add(p1);
                    Font font = new Font("Verdana", Font.BOLD, 25);
                    Font font1 = new Font("Verdana", Font.BOLD, 16);
                    Font font2 = new Font("Verdana", Font.BOLD, 14);
                    JLabel texto1 = new JLabel("USUARIO");
                    texto1.setBounds(75, 100, 300, 60);
                    
                    texto1.setFont(font);
                    texto1.setForeground(new Color(222, 169, 124));
                    p1.add(texto1);


                    
                    UsuarioTexto.setBounds(40,150,210,25);
                    UsuarioTexto.setFont(font1);
                    p1.add(UsuarioTexto);

                    JLabel texto2 = new JLabel("CONTRASEÑA");
                    texto2.setBounds(45, 250, 250, 60);
                    texto2.setFont(font);
                    texto2.setForeground(new Color(222, 169, 124));
                    p1.add(texto2);

                    contra.setBounds(40,300,210,25);
                    contra.setFont(font1);
                    p1.add(contra);



                   contra.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 15) {
                    super.insertString(offs, str, a);
                }
            }
        });

        JButton botonAceptar= new JButton("ACEPTAR");
        botonAceptar.setBounds(150,400,120,30);
        botonAceptar.setFont(font2);
        botonAceptar.setBackground(new Color(49, 66, 109));
        botonAceptar.setOpaque(true); 
        botonAceptar.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        botonAceptar.setFocusPainted(false);
        p1.add(botonAceptar);
        botonAceptar.setEnabled(false);
        
       UsuarioTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                enableButton();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                enableButton();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                enableButton();
            }
            public void enableButton() {
                if (!UsuarioTexto.getText().isEmpty() && contra.getPassword().length > 0) {
                    botonAceptar.setEnabled(true);
                } else {
                    botonAceptar.setEnabled(false);
                }
            }
        });
        
        contra.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                enableButton();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                enableButton();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                enableButton();
            }
            public void enableButton() {
                if (!UsuarioTexto.getText().isEmpty() && contra.getPassword().length > 0) {
                    botonAceptar.setEnabled(true);
                } else {
                    botonAceptar.setEnabled(false);
                }
            }
        });
         
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                mysql s = new mysql();
                String pass = new String (contra.getPassword());
                s.start(null, UsuarioTexto.getText(), pass);
                setVisible(false);
            }
        });
       

            }


    }
