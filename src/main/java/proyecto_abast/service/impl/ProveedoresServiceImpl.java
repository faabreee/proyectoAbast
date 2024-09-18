package proyecto_abast.service.impl;

import proyecto_abast.entity.ProveedorEntity;
import proyecto_abast.repository.ProveedoresRepository;
import proyecto_abast.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
	@Autowired
	ProveedoresRepository rp;
	
	@Override
	public List<ProveedorEntity> listar() {
		
		return rp.findByEstado(1);
	}

	@Override
	public ProveedorEntity buscarProveedor(int codigo) {
		
		return rp.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarProveedor(ProveedorEntity obj) {
		ProveedorEntity prov = rp.findById(obj.getIdproveedor()).orElse(null);
		prov.setEstado(0);
		rp.save(prov);
		
	}

	@Override
	public void modificarProveedor(ProveedorEntity obj) {
		ProveedorEntity prov = rp.findById(obj.getIdproveedor()).orElse(null);
		prov.setIdproveedor(obj.getIdproveedor());
		prov.setCelular(obj.getCelular());
		prov.setCorreo(obj.getCorreo());
		prov.setRazonsocial(obj.getRazonsocial());
		prov.setRucdni(obj.getRucdni());
		prov.setEstado(1);
		rp.save(prov);
	}

	@Override
	public void crearProveedor(ProveedorEntity obj) {
		rp.save(obj);
		
	}

}
