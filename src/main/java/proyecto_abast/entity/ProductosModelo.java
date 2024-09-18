package proyecto_abast.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosModelo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String name;
	private String idCliente;
	@NotNull
	private int cantidad;
	@NotNull
	private Double costo;

}
