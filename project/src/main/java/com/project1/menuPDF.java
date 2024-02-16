package com.project1;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

public class menuPDF extends JFrame {
        public menuPDF(){
            this.setSize(600,300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Convertidor de archivo PNG a PDF");
            setLocation(WIDTH, HEIGHT);
            this.iniciar();
        
    }
        public void iniciar(){
           
            JPanel Vpane = new JPanel();
            Vpane.setBackground(Color.GRAY);
            Vpane.setLayout(null);
            this.getContentPane().add(Vpane);
            JButton Vbutton1 = new JButton();
            JButton actionB = new JButton();
            Vbutton1.setText("Cerrar");
            actionB.setText("Examinar");
            Vbutton1.setBounds(Vpane.getX()+200,Vpane.getY()+100,100,20);
            actionB.setBounds(100,100,100,20);
            Vpane.add(Vbutton1);
            Vpane.add(actionB);

           
            Vbutton1.addActionListener(e -> {
                ventana v1 = new ventana();
                this.setVisible(false);
                v1.setVisible(true);
             
                
              });





              


              
                // Funcion de convertidor de imagen a pdf

 
            actionB.addActionListener(e -> {
                    Vbutton1.setEnabled(false);
                    actionB.setEnabled(false);
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(true);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png");
                    fileChooser.setFileFilter(filter);
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();
            try {
                Document document = new Document();
                String s  = JOptionPane.showInputDialog(null,"AGREGUE UN NOMBRE AL DOCUMENTO");
                PdfWriter.getInstance(document, new FileOutputStream("export/"+s+".pdf"));
                document.open();
                for (File file : selectedFiles) {
                    URL imageUrl = file.toURI().toURL();
                    Image image = Image.getInstance(imageUrl);
                    image.scaleToFit(400, 400);
                    document.add(image);
                }
            document.close();
            System.out.println("PDF file generated successfully.");
            JOptionPane.showMessageDialog(null,"SE HE CONVERTIDO CORRECTAMENTE");
            actionB.setEnabled(true);
            Vbutton1.setEnabled(true);
            } 
            catch (IOException ex) {
                ex.printStackTrace();
                actionB.setEnabled(true);
                Vbutton1.setEnabled(true);
            }
        }
                  });
      }


    }

