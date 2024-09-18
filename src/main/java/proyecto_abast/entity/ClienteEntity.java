package proyecto_abast.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_clientes")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcliente;
	private String rucdni;
	@NotEmpty
	private String razonsocial;
	private String direccion;
	private String celular;
	private int estado;

}
