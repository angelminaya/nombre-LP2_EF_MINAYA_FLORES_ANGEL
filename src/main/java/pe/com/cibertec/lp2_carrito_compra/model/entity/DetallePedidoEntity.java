package pe.com.cibertec.lp2_carrito_compra.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedidoEntity {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detalleId;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "fk_pedido", nullable = false)
	private PedidoEntity pedidoEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_producto", nullable = false)
	private ProductoEntity productoEntity;


           // constructor
	public DetallePedidoEntity(Integer detalleId, Integer cantidad, PedidoEntity pedidoEntity,
			ProductoEntity productoEntity) {

		this.detalleId = detalleId;
		this.cantidad = cantidad;
		this.pedidoEntity = pedidoEntity;
		this.productoEntity = productoEntity;
	}

	public DetallePedidoEntity() {
	}

	public Integer getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(Integer detalleId) {
		this.detalleId = detalleId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public PedidoEntity getPedidoEntity() {
		return pedidoEntity;
	}

	public void setPedidoEntity(PedidoEntity pedidoEntity) {
		this.pedidoEntity = pedidoEntity;
	}

	public ProductoEntity getProductoEntity() {
		return productoEntity;
	}

	public void setProductoEntity(ProductoEntity productoEntity) {
		this.productoEntity = productoEntity;
	}
	
	
	
}
