package proyecto_abast.repository;

import proyecto_abast.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VentasRepository extends JpaRepository<VentaEntity, String>{

}
