package proyecto_abast.repository;

import proyecto_abast.entity.OperacionEntity;
import proyecto_abast.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacionesRepository extends JpaRepository<OperacionEntity, Integer>{
	
	List<OperacionEntity> findByProducto(ProductoEntity producto);
	
}
