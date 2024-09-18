package proyecto_abast.repository;

import proyecto_abast.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsuariosRepository extends JpaRepository<UsuarioEntity, Integer>{

	
	List<UsuarioEntity> findByUsuarioAndClave(String usuario, String clave);
}
