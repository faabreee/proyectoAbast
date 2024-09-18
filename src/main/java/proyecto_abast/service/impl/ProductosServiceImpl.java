package proyecto_abast.service.impl;

import proyecto_abast.entity.ProductoEntity;
import proyecto_abast.repository.ProductosRepository;
import proyecto_abast.service.ProductosService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	ProductosRepository sp;
	
	@Override
	public List<ProductoEntity> listar() {
		
		return sp.findByEstado(1);
	}

	@Override
	public ProductoEntity buscarProducto(int codigo) {
		
		return sp.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarProducto(ProductoEntity obj) {
		ProductoEntity cap = sp.findById(obj.getIdprod()).orElse(null);
		cap.setEstado(0);
		sp.save(cap);
	}

	@Override
	public void modificarProducto(ProductoEntity obj) {
		ProductoEntity cap = sp.findById(obj.getIdprod()).orElse(null);
		cap.setDescripcion(obj.getDescripcion());
		cap.setPrecio(obj.getPrecio());
		cap.setProveedor(obj.getProveedor());
		cap.setStock_max(obj.getStock_max());
		cap.setStock_min(obj.getStock_min());
		cap.setTipo(obj.getTipo());
		sp.save(cap);
	}

	@Override
	public void crearProducto(ProductoEntity obj) {
		sp.save(obj);
	}

	@Override
	public JasperPrint exportReport(String repor) throws FileNotFoundException, JRException {
		
		List<ProductoEntity>listadoP = sp.findByEstado(1);
		File archivo = ResourceUtils.getFile(repor);
		JasperReport report = JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listadoP);
		Map<String,Object> parametros = new HashMap<>();
		JasperPrint print = JasperFillManager.fillReport(report, parametros,ds);
		
		return print;
		
	}

	
	
}
