package proyecto_abast.service;

import proyecto_abast.entity.ProductoEntity;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductosService {

	public List<ProductoEntity> listar();
	public ProductoEntity buscarProducto(int codigo);
	public void eliminarProducto(ProductoEntity obj);
	public void modificarProducto(ProductoEntity obj);
	public void crearProducto(ProductoEntity obj);
	public JasperPrint exportReport(String report)throws FileNotFoundException, JRException;
}
