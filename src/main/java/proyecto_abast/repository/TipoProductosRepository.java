package proyecto_abast.repository;

import proyecto_abast.entity.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TipoProductosRepository extends JpaRepository<TipoProductoEntity, Integer> {

}
