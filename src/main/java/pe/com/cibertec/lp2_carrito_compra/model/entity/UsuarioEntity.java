package pe.com.cibertec.lp2_carrito_compra.model.entity;

import java.time.LocalDate; // Importación de la clase LocalDate para manejar fechas

import jakarta.persistence.Column; // Importación de la anotación Column para mapear columnas en la base de datos
import jakarta.persistence.Entity; // Importación de la anotación Entity para definir la clase como una entidad JPA
import jakarta.persistence.Id; // Importación de la anotación Id para marcar el campo ID de la entidad
import jakarta.persistence.Table; // Importación de la anotación Table para especificar el nombre de la tabla
import lombok.Getter; // Importación de la anotación Getter para generar métodos getter automáticamente
import lombok.NoArgsConstructor; // Importación de la anotación NoArgsConstructor para generar un constructor sin parámetros
import lombok.Setter; // Importación de la anotación Setter para generar métodos setter automáticamente
import lombok.ToString; // Importación de la anotación ToString para generar un método toString automáticamente

// Anotación que define la clase como una entidad JPA
@Entity
// Anotación que especifica el nombre de la tabla en la base de datos
@Table(name = "tb_usuario")
// Generación de métodos getter para los campos de la clase
@Getter
// Generación de métodos setter para los campos de la clase
@Setter
// Generación de un constructor sin parámetros
@NoArgsConstructor
public class UsuarioEntity {

    // Campo que representa el correo del usuario, que es la clave primaria
    @Id
    @Column(name = "correo", nullable = false, length = 60) // Mapeo a la columna "correo" en la base de datos
    private String correo;
    
    // Campo que representa la contraseña del usuario, mapeado a la columna correspondiente
    @Column(name = "password", nullable = false) // La contraseña no puede ser nula
    private String password;
    
    // Campo que representa el nombre del usuario, mapeado a la columna correspondiente
    @Column(name = "nombres", nullable = false) // El nombre no puede ser nulo
    private String nombre;
    
    // Campo que representa el apellido del usuario, mapeado a la columna correspondiente
    @Column(name = "apellidos", nullable = false) // El apellido no puede ser nulo
    private String apellido;
    
    // Campo que representa la fecha de nacimiento del usuario, mapeado a la columna correspondiente
    @Column(name = "fecha_nacimiento", nullable = false) // La fecha de nacimiento no puede ser nula
    private LocalDate fechaNacimiento;
    
    // Campo que representa la URL de la imagen del usuario, mapeado a la columna correspondiente
    @Column(name = "url_imagen") // Este campo puede ser nulo
    private String urlImagen;
}
