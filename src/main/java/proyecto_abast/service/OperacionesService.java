package proyecto_abast.service;

import proyecto_abast.entity.OperacionEntity;

import java.util.List;

public interface OperacionesService {

	public void crearOperaciones(OperacionEntity obj);
	public void crearMultiplesOperaciones(List<OperacionEntity> obj);

}
