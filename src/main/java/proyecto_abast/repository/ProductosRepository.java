package proyecto_abast.repository;

import proyecto_abast.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Integer>{
	
	List<ProductoEntity> findByEstado(int estado);
	
	
}
