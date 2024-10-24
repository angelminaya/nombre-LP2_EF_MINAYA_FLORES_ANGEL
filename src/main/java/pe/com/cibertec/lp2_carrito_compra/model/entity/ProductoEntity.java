package pe.com.cibertec.lp2_carrito_compra.model.entity;

import java.time.LocalDate; // Importación de la clase LocalDate para trabajar con fechas

import jakarta.persistence.Column; // Importación de la anotación Column para mapear columnas de la base de datos
import jakarta.persistence.Entity; // Importación de la anotación Entity para definir la clase como entidad JPA
import jakarta.persistence.GeneratedValue; // Importación de la anotación GeneratedValue para la generación automática de IDs
import jakarta.persistence.GenerationType; // Importación de la enumeración GenerationType para definir la estrategia de generación
import jakarta.persistence.Id; // Importación de la anotación Id para marcar el campo ID de la entidad
import jakarta.persistence.Table; // Importación de la anotación Table para definir la tabla en la base de datos
import lombok.AllArgsConstructor; // Importación de la anotación AllArgsConstructor para generar un constructor con todos los campos
import lombok.Getter; // Importación de la anotación Getter para generar métodos getter automáticamente
import lombok.NoArgsConstructor; // Importación de la anotación NoArgsConstructor para generar un constructor sin parámetros
import lombok.Setter; // Importación de la anotación Setter para generar métodos setter automáticamente

// Anotación que define la clase como una entidad JPA
@Entity
// Generación de métodos getter para los campos de la clase
@Getter
// Generación de métodos setter para los campos de la clase
@Setter
// Generación de un constructor sin parámetros
@NoArgsConstructor
// Generación de un constructor con todos los parámetros
@AllArgsConstructor
// Anotación que define el nombre de la tabla en la base de datos
@Table(name = "tb_producto")
public class ProductoEntity {

    // Campo que representa el ID del producto, generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;
    
    // Campo que representa el nombre del producto, mapeado a la columna correspondiente
    @Column(name = "Nombre Producto")
    private String nombre;
    
    // Campo que representa el precio del producto, mapeado a la columna correspondiente
    @Column(name = "precio")
    private Double precio;
    
    // Campo que representa el stock disponible del producto, mapeado a la columna correspondiente
    @Column(name = "stock")
    private Integer stock;
    
    // Campo que representa la categoría del producto, mapeado a la columna correspondiente
    @Column(name = "Categoria")
    private String categoria;
}