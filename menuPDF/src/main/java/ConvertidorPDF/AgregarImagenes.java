/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConvertidorPDF;
import java.awt.image.ImageFilter;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Tibu
 */
public class AgregarImagenes {
    public void Agregar(){
          JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Imagen");
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new ImageFilter());
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File[] filesToSave = fileChooser.getSelectedFiles();
            for (File imageFile : filesToSave) {
                try {
                    // Crear la carpeta ImportImagen si no existe
                    File importImagenFolder = new File("ImportImagen");
                    if (!importImagenFolder.exists()) {
                        importImagenFolder.mkdir();
                    }
                    // Guardar la imagen en la carpeta ImportImagen con el mismo formato
                    String imageName = imageFile.getName();
                    String imageFormat = imageName.substring(imageName.lastIndexOf('.') + 1);
                    File destinationFile = new File(importImagenFolder.getAbsolutePath() + File.separator + imageName);
                    ImageIO.write(ImageIO.read(imageFile), imageFormat, destinationFile);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar la imagen: " + imageFile.getName());
                }
            }
                JOptionPane.showMessageDialog(null, "Todas las imágenes han sido guardadas correctamente.");
            }
        }
    static class ImageFilter extends javax.swing.filechooser.FileFilter {
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            String extension = getExtension(file);
            return extension != null && (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("gif"));
        }
        public String getDescription() {
            return "Archivos de imagen (*.jpg, *.jpeg, *.png, *.gif)";
        }
        private String getExtension(File file) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf == -1 || lastIndexOf == 0 || lastIndexOf == name.length() - 1) {
                return null;
            }
            return name.substring(lastIndexOf + 1);
        }
    }
    }