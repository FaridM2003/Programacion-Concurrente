/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActualizacionImagenes;

import com.project.menupdf.MenuPDF;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tibu
 */
public class ActualizarFrame {
    public void ActualizarFrame(){
        List<ImageIcon> imageIcons = new ArrayList<>();
        int maxWidth = 200;
        int maxHeight = 200;
        File folder = new File("imagesFolder");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Image image = ImageIO.read(file);
                        int originalWidth = image.getWidth(null);
                        int originalHeight = image.getHeight(null);
                        int scaledWidth = originalWidth;
                        int scaledHeight = originalHeight;
                        if (originalWidth > maxWidth || originalHeight > maxHeight) {
                            double widthScale = (double) maxWidth / originalWidth;
                            double heightScale = (double) maxHeight / originalHeight;
                            double scale = Math.min(widthScale, heightScale);
                            scaledWidth = (int) (originalWidth * scale);
                            scaledHeight = (int) (originalHeight * scale);
                        }
                        Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(scaledImage);
                        imageIcons.add(icon);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
           MenuPDF v1 = new MenuPDF();
        for (ImageIcon icon : imageIcons) {
                JLabel label = new JLabel(icon);
                v1.AlmacenImagenes.add(label);
            }
     
        
    }
}
