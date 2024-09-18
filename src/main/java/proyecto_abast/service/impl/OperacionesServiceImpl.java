package proyecto_abast.service.impl;

import proyecto_abast.entity.OperacionEntity;
import proyecto_abast.repository.OperacionesRepository;
import proyecto_abast.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionesServiceImpl implements OperacionesService {
	@Autowired
	OperacionesRepository ro;
	
	@Override
	public void crearOperaciones(OperacionEntity obj) {
		
		ro.save(obj);
		
	}

	@Override
	public void crearMultiplesOperaciones(List<OperacionEntity> obj) {
		
		ro.saveAll(obj);
		
	}

}
