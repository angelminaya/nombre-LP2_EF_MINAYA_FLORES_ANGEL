package pe.com.cibertec.lp2_carrito_compra.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.lp2_carrito_compra.model.entity.UsuarioEntity;

// Interfaz que define los métodos para el servicio de usuarios

public interface UsuarioService {
	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);
	boolean validarUsuario(UsuarioEntity usuarioEntity);
	UsuarioEntity buscarUsuarioPorCorreo(String correo);
}
