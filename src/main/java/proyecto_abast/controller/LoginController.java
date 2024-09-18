package proyecto_abast.controller;

import proyecto_abast.entity.UsuarioEntity;
import proyecto_abast.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
    UsuariosService usuariosService;
	
	@GetMapping("autentificar")
	public ModelAndView autentificarUsers() {
		ModelAndView mav = new ModelAndView("autentificacion");
		mav.addObject("pqteusers",new UsuarioEntity());
		return mav;
	}
	
	@PostMapping("/ejecutar_autentificacion")
	public String ejecutarAutentificacion(@ModelAttribute (name = "pqteusers") UsuarioEntity obj, BindingResult result, RedirectAttributes attribute) {
	
		boolean val = usuariosService.validarLogin(obj.getUsuario(),obj.getClave());
		if (val==false) {
			attribute.addFlashAttribute("warning","Datos de usuario incorrectos.");
			return "redirect:/autentificar";
		}
		
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
}
