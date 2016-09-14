package com.pshop.station.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pshop.station.persistence.pojo.Fuente;
import com.pshop.station.persistence.pojo.Usuario;
import com.pshop.station.service.FuenteService;
import com.pshop.station.service.UsuarioService;
import com.pshop.station.validator.FuenteValidator;

/**
 * 
 * @author hustler
 *
 */
@Controller
@RequestMapping("/fuente")
public class FuenteController {

	private Logger logger = Logger.getLogger(FuenteController.class);
	private static final String NAME_CONTROLLER="[--FuenteController--]";

	@Autowired
	private FuenteService fuenteService;
	
	@Autowired
	private FuenteValidator fuenteValidator;
	
	@Autowired
	private UsuarioService usuarioService;

	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(fuenteValidator);
	}

	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public String getAll(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("fuenteController.getAll(): "+NAME_CONTROLLER+"/getAll");

		HttpSession session= (HttpSession) request.getSession(false);
		if(session!=null && session instanceof HttpSession && session.getAttribute("token")!=null){
			List<Fuente> fuenteList = fuenteService.getAll();
			if(fuenteList != null){
				//procesando usuarios
				for(Fuente fue: fuenteList){
					Usuario u = this.usuarioService.byIdUser(fue.getIdUsuarioUmodif());
					if(u!=null){
						fue.setUsuario(u.getEmail());
					}
				}
				model.addAttribute("fuentes",fuenteList);
			}
			model.addAttribute("fuente", new Fuente());
		}else{
			response.sendRedirect(request.getContextPath());
		}
		return "fuentesAdmin";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String fuenteAdd(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("fuenteController.fuenteAdd(): "+NAME_CONTROLLER+"/add");
		logger.info("---------------------------------------------------------------------------------");

		HttpSession session= (HttpSession) request.getSession(false);
		if(session!=null && session instanceof HttpSession && session.getAttribute("token")!=null){
			model.addAttribute("fuente", new Fuente());
		}else{
			response.sendRedirect(request.getContextPath());
		}

		return "fuenteAdd";
	}
	
	@RequestMapping(value="/saveFuente",method = RequestMethod.POST)
	public String saveFuente(Model model, HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("fuente") @Validated Fuente fuente,
			BindingResult result) throws IOException{
		logger.info("FuenteController.fuenteAdd(): "+NAME_CONTROLLER+"/saveFuente");
		
		if(result.hasErrors()){
			return "fuenteAdd";
		}
		
		logger.info("fuenteObject: "+fuente.toString());
		
		HttpSession session= (HttpSession) request.getSession(false);
		if(session!=null && session instanceof HttpSession && session.getAttribute("token")!=null){
//			if(publicacion!=null){
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				logger.info("Se va a guardar la nueva fuente");
				
				fuente.setFechaUmodif(new Date());
				fuente.setIdUsuarioUmodif(usuario.getId());
				fuenteService.saveOrUpdateFuente(fuente);
				
				List<Fuente> coleccionList = fuenteService.getAll();
				model.addAttribute("fuentes", coleccionList);	
//			}
//			else{
//				log.info("La nueva editorial es null, regresamos a la misma pantalla");
//				return "editorialAdd";
//			}
		}else{
			response.sendRedirect(request.getContextPath());
		}
		return "fuentesAdmin";
	}
}
