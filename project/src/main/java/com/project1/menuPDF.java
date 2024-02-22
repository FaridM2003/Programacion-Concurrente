package com.project1;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
public class menuPDF extends JFrame {
     String usuari;
    public void AgregarUsuario(String AgregarUsuario){
        usuari = AgregarUsuario;
        System.out.println(usuari);
        iniciar();
    }
    ImageIcon imagen1 = new ImageIcon("images/background3.jpeg");
        public menuPDF(){
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
                java.awt.Image image1 = image.getScaledInstance(getWidth(), getHeight(),java.awt.Image.SCALE_SMOOTH);
                ImageIcon newImageIcon = new ImageIcon(image1);
                    JLabel background = new JLabel(newImageIcon, JLabel.CENTER);
                    add(background);
            System.out.println(usuari);
        
    }
        public void iniciar(){
            System.out.println(usuari);
        
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
                Font font2 = new Font("Verdana", Font.BOLD, 14);
            JButton cerrarVentana = new JButton("Cerrar");
            JButton ExaminarBtton = new JButton("Examinar");
            JLabel textoUser = new JLabel("Bienvenido, "+usuari);
            textoUser.setForeground(new Color(222, 169, 124));
            cerrarVentana.setBounds(40,300,210,25);
            textoUser.setBounds(75, 100, 300, 60);
            ExaminarBtton.setBounds(40,150,210,25);
            cerrarVentana.setFont(font2);
            ExaminarBtton.setFont(font2);
            textoUser.setFont(font2);
            p1.add(cerrarVentana);
            p1.add(ExaminarBtton);
            p1.add(textoUser);
        
            cerrarVentana.addActionListener(e -> {
                ventana v1 = new ventana();
                this.setVisible(false);
                v1.setVisible(true);
              });
            // Funcion de convertidor de imagen a pdf
            ExaminarBtton.addActionListener(e -> {
                String exec ="usuario"; 
                mysql n = new mysql();
                try {
                    exec = n.obtenerTipoUsuario(usuari);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                int limiteArchivos = (exec.equals("usuario")) ? 150 : 0;

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(true);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png");
                    fileChooser.setFileFilter(filter);
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        if (fileChooser.getSelectedFiles().length > limiteArchivos && fileChooser.getSelectedFiles().length!=0) {
                            JOptionPane.showMessageDialog(null, "Ha excedido el límite de archivos permitidos.");
 
                            cerrarVentana.getActionListeners();
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Archivos seleccionados correctamente.");
                        }
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
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
                  });
      }


    }

