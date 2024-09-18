package proyecto_abast.service.impl;

import proyecto_abast.entity.NumbersEntity;
import proyecto_abast.repository.NumbersRepository;
import proyecto_abast.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NumbersServiceImpl implements NumbersService {
	@Autowired
	NumbersRepository rn;
	@Override
	public NumbersEntity buscarNumeracion(int id) {
		NumbersEntity num = rn.findById(id).orElse(null);
		int correl = num.getNumeracion() + 1;
		num.setNumeracion(correl);
		rn.save(num);
		return rn.findById(id).orElse(null);
	}

	
	
}
