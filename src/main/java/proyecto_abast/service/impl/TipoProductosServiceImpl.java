package proyecto_abast.service.impl;

import proyecto_abast.entity.TipoProductoEntity;
import proyecto_abast.repository.TipoProductosRepository;
import proyecto_abast.service.TipoproductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductosServiceImpl implements TipoproductosService {
	@Autowired
	TipoProductosRepository rt;
	
	@Override
	public List<TipoProductoEntity> listar() {
		
		return rt.findAll();
	}

}
