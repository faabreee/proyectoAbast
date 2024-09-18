package proyecto_abast.controller;

import proyecto_abast.entity.*;
import proyecto_abast.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/")
public class VentasController {
	List<ProductosModelo> pastilla = new ArrayList<ProductosModelo>();
	
	@Autowired
	private ProductosService productosService;
	@Autowired
	private OperacionesService operacionesService;
	@Autowired
	private ClientesService clientesService;
	@Autowired
	private VentasService ventasService;
	@Autowired
	private NumbersService numbersService;
	
	
	@GetMapping("ventaProductos")
	public ModelAndView venderProducto(Pageable pageable) {
		ModelAndView mav=new ModelAndView("ventaProductos");
		mav.addObject("productolist", productosService.listar());
		mav.addObject("producto",new ProductosModelo());
		mav.addObject("clientelist", clientesService.listar(pageable));
		mav.addObject("capsul",pastilla);
		mav.addObject("clientCapsula",new ClienteEntity());
		return mav;
	}
	
	@PostMapping("ventaProductos/almacenar")
	public String almacenarProducto(@ModelAttribute(name = "capsula") ProductosModelo obj ) {
		obj.setName(productosService.buscarProducto(obj.getIdProducto()).getDescripcion());
		pastilla.add(obj);
		return "redirect:/ventaProductos";
	}
	
	@GetMapping("preguardadoeliminar")
	public String eliminarpreguardado(@ModelAttribute(name = "idp")int obj ) {
		Iterator<ProductosModelo> it = pastilla.iterator();
		while (it.hasNext()) {
			if (it.next().getIdProducto()== obj) {
				it.remove();
			}
		}
		return "redirect:/ventaProductos";
	}
	
	@PostMapping("ventaProductos/guardar")
	public String guardarProducto(@ModelAttribute(name = "orden") ClienteEntity obj ) {
		System.out.println(obj.getIdcliente());
		Date date = new Date(System.currentTimeMillis());
		Double costosum =pastilla.stream().mapToDouble(o -> o.getCosto()).sum();
		String codigoVTA = numbersService.buscarNumeracion(1).codigoconPrefijo();
		VentaEntity venta = VentaEntity.builder()
				.cliente(clientesService.buscarCliente(obj.getIdcliente()))
				.fecha(date)
				.precio(costosum)
				.estado(1)
				.build();


		List<OperacionEntity> paquete = new ArrayList<OperacionEntity>();
		OperacionEntity ope;
		for (ProductosModelo cap : pastilla) {
			ProductoEntity p = productosService.buscarProducto(cap.getIdProducto());
			
			int cant = cap.getCantidad();
			ope = new OperacionEntity(codigoVTA, 2, p, (cant - (cant * 2)), cap.getCosto(), date, 1);
			paquete.add(ope);
		}
		pastilla = new ArrayList<ProductosModelo>();
		operacionesService.crearMultiplesOperaciones(paquete);
		ventasService.crearVemtas(venta);
		return "redirect:/ventaProductos";
	}
	
	
}
