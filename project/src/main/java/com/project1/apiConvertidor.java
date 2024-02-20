package com.project1;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

@WebServlet(name = "ConversionServlet", urlPatterns = {"/convertir"})
public class ConversionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("export/imagen.pdf"));
            document.open();

            // Aquí iría la lógica para convertir la imagen a PDF
            // Por ejemplo:
            Image image = Image.getInstance("ruta/a/imagen.png");
            document.add(image);

            document.close();
            response.getWriter().println("La conversión se ha realizado con éxito");
        } catch (Exception e) {
            response.getWriter().println("Error al convertir la imagen a PDF: " + e.getMessage());
        }
    }
}
