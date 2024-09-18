package proyecto_abast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tipoproductos")
public class TipoProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipo;
	private String descripcion;

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
