package pe.com.cibertec.lp2_carrito_compra.model.entity;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pedido")
public class PedidoEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pedidoId;
	
	@Column(name = "fecha_compra")
	private LocalDate fechaCompra;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	private UsuarioEntity usuarioEntity;
	
	@OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL)
	private List<DetallePedidoEntity>detallePedido;


        //constructor de los prodcutos
	public PedidoEntity(Integer pedidoId, LocalDate fechaCompra, UsuarioEntity usuarioEntity,
			List<DetallePedidoEntity> detallePedido) {
		this.pedidoId = pedidoId;
		this.fechaCompra = fechaCompra;
		this.usuarioEntity = usuarioEntity;
		this.detallePedido = detallePedido;
	}


	public PedidoEntity() {
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public List<DetallePedidoEntity> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedidoEntity> detallePedido) {
		this.detallePedido = detallePedido;
	}
	
	
	
	
	
	
	
	
	
	
	
}
