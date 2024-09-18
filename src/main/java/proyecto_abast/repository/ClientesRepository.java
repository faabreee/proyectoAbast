package proyecto_abast.repository;

import proyecto_abast.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClienteEntity,Integer>{

	Page<ClienteEntity> findByEstado(int estado, Pageable pageable);
}
