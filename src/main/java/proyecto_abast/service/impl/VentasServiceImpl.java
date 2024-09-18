package proyecto_abast.service.impl;

import proyecto_abast.entity.VentaEntity;
import proyecto_abast.repository.VentasRepository;
import proyecto_abast.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VentasServiceImpl implements VentasService {
	@Autowired
	VentasRepository rv;
	
	@Override
	public void crearVemtas(VentaEntity obj) {
		
		rv.save(obj);
		
	}

}
