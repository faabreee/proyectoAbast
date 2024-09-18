package proyecto_abast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class UsuarioEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idusuario;
private String nombre;
private String usuario;
private String clave;
private int estado;

}
