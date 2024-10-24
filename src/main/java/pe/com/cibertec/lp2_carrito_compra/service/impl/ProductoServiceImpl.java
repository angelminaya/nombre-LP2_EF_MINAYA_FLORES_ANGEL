package pe.com.cibertec.lp2_carrito_compra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.lp2_carrito_compra.model.entity.ProductoEntity;
import pe.com.cibertec.lp2_carrito_compra.repository.ProductoRepository;
import pe.com.cibertec.lp2_carrito_compra.service.ProductoService;

// Implementación del servicio de productos
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository; // Inyección del repositorio para acceder a datos de productos
    
    // Método que busca y retorna todos los productos
    @Override
    public List<ProductoEntity> buscarTodosProductos() {
        return productoRepository.findAll(); // Retorna la lista completa de productos
    }

    // Método que busca un producto por su ID
    @Override
    public ProductoEntity buscarProductoPorId(Integer id) {
        return productoRepository.findById(id).get(); // Retorna el producto encontrado por ID
    }

    // Método que agrega un nuevo producto
    @Override
    public void agregarProducto(ProductoEntity producto) {
        productoRepository.save(producto); // Guarda el nuevo producto en el repositorio
    }

    // Método que actualiza un producto existente
    @Override
    public void actualizarProducto(ProductoEntity producto) {
        productoRepository.save(producto); // Guarda las actualizaciones del producto
    }

    // Método que elimina un producto por su ID
    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id); // Elimina el producto correspondiente al ID proporcionado
    }
}
