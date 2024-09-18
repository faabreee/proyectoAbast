package proyecto_abast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_number")
public class NumbersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idnumber;
	private String prefij;
	private int numeracion;

	public String codigoconPrefijo() {
		String cod = getPrefij() + getNumeracion();
		return cod;
	}

}
