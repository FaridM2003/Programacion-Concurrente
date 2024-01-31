package com.project1;

import java.awt.Color;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfImage;

import java.awt.geom.Rectangle2D;



    public class ventana extends JFrame{
        public ventana(){
            this.setSize(600,300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Convertidor de archivo PNG a PDF");
            setLocation(WIDTH, HEIGHT);



            iniciar();
            
        }

        private void iniciar(){
            //Variables
            JFrame ventana2 = new JFrame("Convertidor de PNG a PDF");

            //paneless
            JPanel pane = new JPanel();
            JPanel Vpane = new JPanel();
            pane.setBackground(Color.GRAY);
            Vpane.setBackground(Color.GRAY);
            pane.setLayout(null);
            Vpane.setLayout(null);
            this.getContentPane().add(pane);
            ventana2.getContentPane().add(Vpane);


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
            JTextField TextF1 = new JTextField();
            JPasswordField TextF2 = new JPasswordField();
            TextF1.setBounds(10,50,200,20);
            TextF2.setBounds(250,50,200,20);
            pane.add(TextF1);
            pane.add(TextF2);



            //botones
            JButton button1 = new JButton();
            JButton Vbutton1 = new JButton();
            JButton actionB = new JButton();
            button1.setText("Aceptar");
            Vbutton1.setText("Cerrar");
            actionB.setText("Examinar");
            button1.setBounds(400,100,100,20);
            Vbutton1.setBounds(Vpane.getX()+200,Vpane.getY()+100,100,20);
            actionB.setBounds(100,100,100,20);
            button1.setEnabled(false);
            pane.add(button1);
            Vpane.add(Vbutton1);
            Vpane.add(actionB);

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

            button1.addActionListener(e -> {
                ventana2.setSize(400, 300);
                ventana2.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra solo la ventana actual, no termina la aplicación
                ventana2.setVisible(true);
                this.setVisible(false);
                
              });
              Vbutton1.addActionListener(e -> {
                ventana2.setVisible(false);
                this.setVisible(true);
                
              });





                // Funcion de convertidor de imagen a pdf
                actionB.addActionListener(e -> {
                    JFrame frame = new JFrame();
                    JFileChooser fileChooser = new JFileChooser();// Crear nueva instancia de JFileChooser
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");// Limitar la selección a archivos de imagen
                    fileChooser.setFileFilter(filter);
    
                    int result = fileChooser.showOpenDialog(frame);// Mostrar el dialogo de exploración de archivos
                    // Si se selecciona un archivo
                    if (result == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile(); // Obtiene el archivo seleccionado
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                } else {  System.out.println("No file selected"); }
                    
                  });
               
                
            }

    }
