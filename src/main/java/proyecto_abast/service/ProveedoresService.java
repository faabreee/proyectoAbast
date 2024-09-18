package proyecto_abast.service;

import proyecto_abast.entity.ProveedorEntity;

import java.util.List;

public interface ProveedoresService {

	public List<ProveedorEntity> listar();
	public ProveedorEntity buscarProveedor(int codigo);
	public void eliminarProveedor(ProveedorEntity obj);
	public void modificarProveedor(ProveedorEntity obj);
	public void crearProveedor(ProveedorEntity obj);
	
}
