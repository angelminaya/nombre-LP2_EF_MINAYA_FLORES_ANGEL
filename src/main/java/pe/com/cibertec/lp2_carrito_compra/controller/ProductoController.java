package pe.com.cibertec.lp2_carrito_compra.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpSession;
import pe.com.cibertec.lp2_carrito_compra.model.entity.DetallePedidoEntity;
import pe.com.cibertec.lp2_carrito_compra.model.entity.Pedido;
import pe.com.cibertec.lp2_carrito_compra.model.entity.ProductoEntity;
import pe.com.cibertec.lp2_carrito_compra.model.entity.UsuarioEntity;
import pe.com.cibertec.lp2_carrito_compra.service.ProductoService;
import pe.com.cibertec.lp2_carrito_compra.service.UsuarioService;
import pe.com.cibertec.lp2_carrito_compra.service.impl.PdfService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/menu")
	public String mostrarMenu(HttpSession sesion, Model model) {


                //comprobando el usuario
		if(sesion.getAttribute("usuario") == null) {
			return "redirect:/";
		}


		// Obtener valor de sesión
		String correo = sesion.getAttribute("usuario").toString();
		UsuarioEntity usuarioEncontrado = usuarioService
				.buscarUsuarioPorCorreo(correo);
		model.addAttribute("foto", usuarioEncontrado.getUrlImagen());
		
		List<Pedido>productoSesion = null;
		if(sesion.getAttribute("carrito") == null) {
			productoSesion = new ArrayList<>();
		}else {
			productoSesion = (List<Pedido>) sesion.getAttribute("carrito");
		}
		model.addAttribute("cant_carrito", productoSesion.size());
		

		// Ver carrito con datos , de los productos
		List<DetallePedidoEntity>detallePedidoEntity = new ArrayList<>();
		Double totalPedido = 0.0;
		
		for(Pedido pedido: productoSesion) {
			DetallePedidoEntity det = new DetallePedidoEntity();
			ProductoEntity pro = productoService.buscarProductoPorId(
					pedido.getProductoId());
			det.setProductoEntity(pro);
			det.setCantidad(pedido.getCantidad());
			detallePedidoEntity.add(det);
			totalPedido += pedido.getCantidad() * pro.getPrecio();
		}
		
		model.addAttribute("carrito", detallePedidoEntity);
		model.addAttribute("total", totalPedido);
		// fin ver carrito con datos
		List<ProductoEntity>listaProductos = productoService.buscarTodosProductos();
		model.addAttribute("productos", listaProductos);
		return "menu";
	}
	
	@GetMapping("/agregar_producto")
    public String mostrarFormularioAgregarProducto(Model model) {
        return "agregar_producto";
    }
	
	@PostMapping("/guardar_producto")
	public String guardarProducto(
			@RequestParam("nombre") String nombre,
            @RequestParam("precio") Double precio,
            @RequestParam("stock") Integer stock,
            @RequestParam("categoria") String categoria) {
		ProductoEntity nuevoProducto = new ProductoEntity();
		nuevoProducto.setNombre(nombre);
		nuevoProducto.setPrecio(precio);
		nuevoProducto.setStock(stock);
		nuevoProducto.setCategoria(categoria);
		
		productoService.agregarProducto(nuevoProducto);
		return "redirect:/menu";
	}
	
	 @GetMapping("/ver_producto/{id}")
	    public String verProducto(@PathVariable("id") Integer id, Model model) {
	        ProductoEntity producto = productoService.buscarProductoPorId(id);
	        model.addAttribute("producto", producto);
	        return "ver_producto";
	    }
	 
	 @GetMapping("/editar_producto/{id}")
	    public String editarProducto(@PathVariable("id") Integer id, Model model) {
	        ProductoEntity producto = productoService.buscarProductoPorId(id);
	        model.addAttribute("producto", producto);
	        return "editar_producto";
	    }
	 
	 @PostMapping("/eliminar_producto/{id}")
	    public String eliminarProducto(@PathVariable("id") Integer id) {
	        productoService.eliminarProducto(id);
	        return "redirect:/menu";
	    }
	 
	 @PostMapping("/actualizar_producto")
	 public String actualizarProducto(@ModelAttribute ProductoEntity producto) {
	     productoService.actualizarProducto(producto);
	     return "redirect:/menu";
	 }
	
	@GetMapping("/generar_pdf")
	public ResponseEntity<InputStreamResource>generarPdf(HttpSession sesion) 
			throws IOException{
		
		List<Pedido>productoSesion = null;
		if(sesion.getAttribute("carrito") == null) {
			productoSesion = new ArrayList<>();
		}else {
			productoSesion = (List<Pedido>) sesion.getAttribute("carrito");
		}
		
		// Ver carrito con datos
		List<DetallePedidoEntity>detallePedidoEntity = new ArrayList<>();
		Double totalPedido = 0.0;
		

                
                //registra los pedidos deseados
		for(Pedido pedido: productoSesion) {
			DetallePedidoEntity det = new DetallePedidoEntity();
			ProductoEntity pro = productoService.buscarProductoPorId(
					pedido.getProductoId());
			det.setProductoEntity(pro);
			det.setCantidad(pedido.getCantidad());
			detallePedidoEntity.add(det);
			totalPedido += pedido.getCantidad() * pro.getPrecio();
		}



		Map<String, Object> datosPdf = new HashMap<String, Object>();
		datosPdf.put("factura", detallePedidoEntity);
		datosPdf.put("precio_total", totalPedido);
		
		ByteArrayInputStream pdfBytes = pdfService.generarPdf("template_pdf", 
				datosPdf);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=productos.pdf");
		
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdfBytes));
		
	}	
}

