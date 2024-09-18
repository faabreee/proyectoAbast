package proyecto_abast.repository;

import proyecto_abast.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedoresRepository extends JpaRepository<ProveedorEntity, Integer>{

	
	List<ProveedorEntity> findByEstado(int estado);
	
}
