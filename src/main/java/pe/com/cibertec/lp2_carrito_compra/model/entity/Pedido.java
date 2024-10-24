package pe.com.cibertec.lp2_carrito_compra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Pedido {
	private Integer productoId;
	private Integer cantidad;
	

         // crenado los cosntructores
	public Pedido(Integer productoId, Integer cantidad) {
		this.productoId = productoId;
		this.cantidad = cantidad;
	}
	public Pedido() {
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
