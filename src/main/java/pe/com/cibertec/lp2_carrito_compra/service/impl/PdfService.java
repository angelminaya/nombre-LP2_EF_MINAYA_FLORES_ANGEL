package pe.com.cibertec.lp2_carrito_compra.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;

// Clase que proporciona servicios para generar documentos PDF
@Service
public class PdfService {

    @Autowired
    private SpringTemplateEngine templateEngine; // Inyección del motor de plantillas Thymeleaf
    
    // Método que genera un PDF a partir de una plantilla y datos proporcionados
    public ByteArrayInputStream generarPdf(String templateNombre, Map<String, Object> datos) throws IOException {
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Flujo de salida para el PDF
        Context context = new Context(); // Contexto para Thymeleaf
        context.setVariables(datos); // Establecer las variables en el contexto
        String html = templateEngine.process(templateNombre, context); // Procesar la plantilla HTML
        HtmlConverter.convertToPdf(new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)), outputStream); // Convertir HTML a PDF
        return new ByteArrayInputStream(outputStream.toByteArray()); // Retornar el PDF como InputStream
    }
}
