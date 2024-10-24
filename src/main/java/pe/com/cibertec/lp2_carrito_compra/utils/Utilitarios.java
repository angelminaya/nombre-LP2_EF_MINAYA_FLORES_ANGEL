package pe.com.cibertec.lp2_carrito_compra.utils;

import java.io.IOException;
import java.nio.file.Files; // Importación para trabajar con archivos
import java.nio.file.Path; 
import java.nio.file.Paths;

import org.mindrot.jbcrypt.BCrypt; // Importación para el manejo de contraseñas
import org.springframework.web.multipart.MultipartFile; 

public class Utilitarios {

    // Método para guardar una imagen en el sistema de archivos
    public static String guardarImagen(MultipartFile foto) {
        try {
            Path pathDire = Paths.get("src/main/resources/static/usuario_foto/"); // Definición del directorio para las fotos
            if (!Files.exists(pathDire)) {
                Files.createDirectories(pathDire); // Crear el directorio si no existe
            }
            
            byte[] bytes = foto.getBytes(); // Obtener los bytes de la imagen subida
            Path path = Paths.get("src/main/resources/static/usuario_foto/" + 
            foto.getOriginalFilename()); 
            
            Files.write(path, bytes); // Escribir los bytes en el archivo
            return foto.getOriginalFilename(); // Retornar el nombre del archivo guardado
            
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Manejo de excepciones
            return null; // Retornar null si hubo un error
        }
    }
    
    // Método para generar un hash a partir de una contraseña en texto plano
    public static String extraerHash(String passwordTextoPlano) {
        return BCrypt.hashpw(passwordTextoPlano, BCrypt.gensalt()); 
    }
}
