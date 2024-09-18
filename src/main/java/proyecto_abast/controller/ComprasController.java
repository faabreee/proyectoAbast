package proyecto_abast.controller;

import proyecto_abast.entity.OperacionEntity;
import proyecto_abast.entity.ProductoEntity;
import proyecto_abast.entity.ProductosModelo;
import proyecto_abast.service.OperacionesService;
import proyecto_abast.service.ProductosService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/")
public class ComprasController {
	List<ProductosModelo> pastilla = new ArrayList<ProductosModelo>();
	
	@Autowired
	private ProductosService productosService;
	@Autowired
	private OperacionesService operacionesService;

	@GetMapping("listar_Ctrl_Reposicion")
	public ModelAndView listarCtrlReposicion() {
		ModelAndView mav = new ModelAndView("listarCtrlReposiciones");
		List<ProductoEntity> paquete = productosService.listar();
		mav.addObject("paqueteP",paquete);
		return mav;
	}
	
	@GetMapping("reponer_producto")
	public ModelAndView obtenerProducto(@RequestParam(name = "idpro")int idprod) {
		ModelAndView mav=new ModelAndView("reponerProducto");
		mav.addObject("productoP",productosService.buscarProducto(idprod));
		return mav;
	
	}
	
	@PostMapping("reponerproducto/actualizar")
	public String reponerProducto(@ModelAttribute(name = "producto") ProductoEntity obj ) {
	    Date date = new Date(System.currentTimeMillis());
		OperacionEntity opr = new OperacionEntity("REPO",1,obj,obj.getStock_min(),obj.getPrecio(),date,1);
		operacionesService.crearOperaciones(opr);
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
	@GetMapping("comprasProductos")
	public ModelAndView comprarProducto() {
		ModelAndView mav=new ModelAndView("compraProductos");
		mav.addObject("productolist",productosService.listar());
		mav.addObject("producto",new ProductosModelo());
		mav.addObject("capsul",pastilla);
		return mav;
	}
	
	@PostMapping("comprasProductos/almacenar")
	public String almacenarProducto(@ModelAttribute(name = "capsula") ProductosModelo obj ) {
		obj.setName(productosService.buscarProducto(obj.getIdProducto()).getDescripcion());
		pastilla.add(obj);
		
		return "redirect:/comprasProductos";
	}
	
	@GetMapping("preguardadoCompraseliminar")
	public String eliminarpreguardado(@ModelAttribute(name = "idp")int obj ) {
		Iterator<ProductosModelo> it = pastilla.iterator();
		while (it.hasNext()) {
			if (it.next().getIdProducto()== obj) {
				it.remove();
			}
		}
		return "redirect:/comprasProductos";
	}
	
	@PostMapping("comprasProductos/guardar")
	public String guardarProducto() {
		Date date = new Date(System.currentTimeMillis());
		List<OperacionEntity> paquete = new ArrayList<OperacionEntity>();
		OperacionEntity ope;
		for (ProductosModelo cap : pastilla) {
			ProductoEntity p = productosService.buscarProducto(cap.getIdProducto());
			int cant = cap.getCantidad();
			ope = new OperacionEntity("COM", 2, p, cant, cap.getCosto(), date, 1);
			paquete.add(ope);
		}
		pastilla = new ArrayList<ProductosModelo>();
		operacionesService.crearMultiplesOperaciones(paquete);
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
	@GetMapping("/reporteReposicion")
	public void exportarPDF(HttpServletResponse response)throws JRException,IOException{
		response.addHeader("Content-disposition", "inline: filename" + "vendedor.pdf");
		response.setContentType("application/pdf");
		ServletOutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(productosService.exportReport("classpath:report_reponer.jrxml"),outputStream);
		outputStream.flush();
		outputStream.close();
	}
	
	
	
}
