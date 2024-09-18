package proyecto_abast.controller;

import proyecto_abast.entity.ClienteEntity;
import proyecto_abast.entity.ProductoEntity;
import proyecto_abast.entity.ProveedorEntity;
import proyecto_abast.service.ClientesService;
import proyecto_abast.service.ProductosService;
import proyecto_abast.service.ProveedoresService;
import proyecto_abast.service.TipoproductosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CrudsController {
	@Autowired
	private ProductosService productosService;
	@Autowired
	private TipoproductosService tipoproductosService;
	@Autowired
	private ProveedoresService proveedoresService;
	@Autowired
	private ClientesService clientesService;
	
	
	@GetMapping("crud_Productos")
	public ModelAndView crudListProductos() {
		ModelAndView mav = new ModelAndView("crudProductos");
		mav.addObject("paqueteP",productosService.listar());
		return mav;
	}
	
	@GetMapping("crud_Clientes")
	public ModelAndView crudListClientes(Pageable pageable, @RequestParam(name="page",defaultValue = "0")int page){
		ModelAndView mav = new ModelAndView("crudClientes");
		mav.addObject("paqueteC",clientesService.listar(pageable));
		mav.addObject("page", page);
		return mav;
	}
	
	@GetMapping("crud_Proveedores")
	public ModelAndView crudListProveedores() {
		ModelAndView mav = new ModelAndView("crudProveedores");
		mav.addObject("paquetePv",proveedoresService.listar());
		return mav;
	}
	
	@GetMapping("crud_eliminar_Producto")
	public ModelAndView crudEliminarProducto(@RequestParam(name="idprod")int idprod) {
		ModelAndView mav=new ModelAndView("crudProductos");
		ProductoEntity p = productosService.buscarProducto(idprod);
		productosService.eliminarProducto(p);
		mav.addObject("paqueteP",productosService.listar());
		return mav;
	}
	
	@GetMapping("crud_eliminar_Cliente")
	public ModelAndView crudEliminarCliente(@RequestParam(name="idcli")int idcli, Pageable pageable){
		ModelAndView mav=new ModelAndView("crudClientes");
		ClienteEntity c = clientesService.buscarCliente(idcli);
		clientesService.eliminarCliente(c);
		mav.addObject("paqueteC",clientesService.listar(pageable));
		return mav;
	}
	
	@GetMapping("crud_eliminar_Proveedor")
	public ModelAndView crudEliminarProveedor(@RequestParam(name="idpro")int idpro) {
		ModelAndView mav=new ModelAndView("crudProveedores");
		ProveedorEntity pv = proveedoresService.buscarProveedor(idpro);
		proveedoresService.eliminarProveedor(pv);
		mav.addObject("paquetePv",proveedoresService.listar());
		return mav;
	}
	

	@GetMapping("crud_invocar_edit_Producto")
	public ModelAndView crudInvocarEditProducto(@RequestParam(name = "idprod")int idprod) {
		ModelAndView mav = new ModelAndView("crudEditProducto");
		ProductoEntity p = productosService.buscarProducto(idprod);
		
		mav.addObject("PaqueteP",p);
		mav.addObject("paquetetp",tipoproductosService.listar());
		mav.addObject("PaquetePv",proveedoresService.listar());
		return mav;
	}
	
	@GetMapping("crud_invocar_edit_Cliente")
	public ModelAndView crudInvocarEditCliente(@RequestParam(name = "idcli")int idcli) {
		ModelAndView mav = new ModelAndView("crudEditCliente");
		mav.addObject("PaqueteC",clientesService.buscarCliente(idcli));
		return mav;
	}
	
	@GetMapping("crud_invocar_edit_Proveedor")
	public ModelAndView crudInvocarEditProveedor(@RequestParam(name = "idpro")int idpro) {
		ModelAndView mav = new ModelAndView("crudEditProveedor");
		mav.addObject("PaquetePv",proveedoresService.buscarProveedor(idpro));
		return mav;
	}
	
	@PostMapping("/crud_ejecutar_edit_Producto")
	public String crudEjecutarEditProducto(@ModelAttribute(name = "producto") ProductoEntity objProducto) {
		productosService.modificarProducto(objProducto);
		return "redirect:/crud_Productos";
	}
	
	@PostMapping("/crud_ejecutar_edit_Cliente")
	public String crudEjecutarEditCliente(@ModelAttribute(name = "paqueteC") ClienteEntity obj2) {
		clientesService.modificarCliente(obj2);
		return "redirect:/crud_Clientes";
	}
	
	@PostMapping("/crud_ejecutar_edit_Proveedor")
	public String crudEjecutarEditProveedor(@ModelAttribute(name = "paquetePv") ProveedorEntity obj) {
		proveedoresService.modificarProveedor(obj);
		return "redirect:/crud_Proveedores";
	}
	
	
	@GetMapping("crud_Crear_Producto")
	public ModelAndView crudCrearProducto() {
		ModelAndView mav=new ModelAndView("crudNewProducto");
		mav.addObject("PaqueteP",new ProductoEntity());
		mav.addObject("paquetetp",tipoproductosService.listar());
		mav.addObject("PaquetePv",proveedoresService.listar());
		return mav;
	}
	
	@GetMapping("crud_Crear_Cliente")
	public ModelAndView crudCrearCliente() {
		ModelAndView mav=new ModelAndView("crudNewCliente");
		mav.addObject("PaqueteC",new ClienteEntity());
		return mav;
	}
	
	@GetMapping("crud_Crear_Proveedor")
	public ModelAndView crudCrearProveedor() {
		ModelAndView mav=new ModelAndView("crudNewProveedor");
		mav.addObject("PaquetePv",new ProveedorEntity());
		return mav;
	}
	
	
	@PostMapping("/crud_ejecutar_crear_producto")
	public String crusEjecutarCrearProducto(@ModelAttribute (name = "PaqueteP") ProductoEntity obj) {
		
		obj.setEstado(1);
		productosService.crearProducto(obj);
		
		return "redirect:/crud_Productos";
	}
	
	@PostMapping("/crud_ejecutar_crear_cliente")
	public String crusEjecutarCrearCliente(@Valid @ModelAttribute (name = "PaqueteC") ClienteEntity obj, BindingResult result) {
		if (result.hasErrors()) {
			return "crudNewCliente";
		}
		
		
		obj.setEstado(1);
		clientesService.crearCliente(obj);
		
		return "redirect:/crud_Clientes";
	}
	
	@PostMapping("/crud_ejecutar_crear_proveedor")
	public String crusEjecutarCrearProveedor(@ModelAttribute (name = "PaquetePv") ProveedorEntity obj) {
		
		obj.setEstado(1);
		proveedoresService.crearProveedor(obj);
		
		return "redirect:/crud_Proveedores";
	}
	
	
}
