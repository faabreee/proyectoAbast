package proyecto_abast.repository;

import proyecto_abast.entity.NumbersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends JpaRepository<NumbersEntity,Integer> {

}
