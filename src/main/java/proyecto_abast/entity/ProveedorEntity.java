package proyecto_abast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_proveedor")
public class ProveedorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproveedor;
	private String rucdni;
	private String razonsocial;
	private String celular;
	private String correo;
	private int estado;

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getRucdni() {
		return rucdni;
	}

	public void setRucdni(String rucdni) {
		this.rucdni = rucdni;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
