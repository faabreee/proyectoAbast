package proyecto_abast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_operaciones")
public class OperacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operaciones;
	private String proceso;
	private int tipo;
	@ManyToOne
	@JoinColumn(name = "producto")
	private ProductoEntity producto;
	private int cantidad;
	private Double preciocpa;
	private Date fechacpa;
	private int estado;


	public OperacionEntity(String proceso, int tipo, ProductoEntity producto, int cantidad,
						   Double precio, Date fechacpa, int estado) {
		this.operaciones = operaciones;
		this.proceso = proceso;
		this.tipo = tipo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.preciocpa = precio;
		this.fechacpa = fechacpa;
		this.estado = estado;
	}

	public int getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(int operaciones) {
		this.operaciones = operaciones;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPreciocpa() {
		return preciocpa;
	}

	public void setPreciocpa(Double preciocpa) {
		this.preciocpa = preciocpa;
	}

	public Date getFechacpa() {
		return fechacpa;
	}

	public void setFechacpa(Date fechacpa) {
		this.fechacpa = fechacpa;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
