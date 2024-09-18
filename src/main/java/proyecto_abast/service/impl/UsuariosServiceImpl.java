package proyecto_abast.service.impl;

import proyecto_abast.repository.UsuariosRepository;
import proyecto_abast.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	UsuariosRepository ru;
	
	@Override
	public boolean validarLogin(String User, String Password) {
		
		boolean valor = false;
		int result = ru.findByUsuarioAndClave(User, Password).size();
		if (result > 0) {
			valor=true;
		}
		return valor;
	}

}
