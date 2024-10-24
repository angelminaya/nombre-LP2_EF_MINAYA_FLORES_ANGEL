package pe.com.cibertec.lp2_carrito_compra.service;

import java.util.List;

import pe.com.cibertec.lp2_carrito_compra.model.entity.ProductoEntity;


// Interfaz que define los métodos para el servicio de productos
public interface ProductoService {
	 void agregarProducto(ProductoEntity producto);
	 List<ProductoEntity> buscarTodosProductos();
	 ProductoEntity buscarProductoPorId(Integer id);
	 void actualizarProducto(ProductoEntity producto);
	 void eliminarProducto(Integer id);
}
