package proyecto_abast.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_ventas")
public class VentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ventas;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private ClienteEntity cliente;
	private Double precio;
	private Date fecha;
	private int estado;


}
