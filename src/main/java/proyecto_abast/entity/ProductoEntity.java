package proyecto_abast.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_productos")
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprod;
	@ManyToOne
	@JoinColumn(name = "tipo")
	private TipoProductoEntity tipo;
	
	private String descripcion;
	
	@Column(name="precio")
	private Double precio;
	private int stock_min;
	private int stock_max;
	@ManyToOne
	@JoinColumn(name = "proveedor")
	private ProveedorEntity proveedor;
	private int estado;
	
	@OneToMany(mappedBy = "producto")
	List<OperacionEntity>lstCantidad;



	public ProductoEntity() {

	}


	public ProductoEntity(int idprod, TipoProductoEntity tipo, String descripcion, Double precio, int stock_min,
						  int stock_max, ProveedorEntity proveedor, int estado, List<OperacionEntity> lstCantidad) {
		this.idprod = idprod;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock_min = stock_min;
		this.stock_max = stock_max;
		this.proveedor = proveedor;
		this.estado = estado;
		this.lstCantidad = lstCantidad;
	}

	
	public int getStock() {
		return lstCantidad.stream().mapToInt(o -> o.getCantidad()).sum();
	}
	
	public boolean getReponer() {
		int stk = getStock();
		boolean men = false;
		if (stk < getStock_min()) {
			men = true;
		}else {
			men = false;
		}
		return men;
	}

	public int getIdprod() {
		return idprod;
	}

	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}

	public TipoProductoEntity getTipo() {
		return tipo;
	}

	public String getNameTipoproducto() {
		return getTipo().getDescripcion();
	}

	public void setTipo(TipoProductoEntity tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}

	public int getStock_max() {
		return stock_max;
	}

	public void setStock_max(int stock_max) {
		this.stock_max = stock_max;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public String getNameproveedor() {
		return proveedor.getRazonsocial();
	}
	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<OperacionEntity> getLstCantidad() {
		return lstCantidad;
	}

	public void setLstCantidad(List<OperacionEntity> lstCantidad) {
		this.lstCantidad = lstCantidad;
	}





}
