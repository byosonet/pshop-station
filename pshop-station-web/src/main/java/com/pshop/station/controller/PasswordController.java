package com.pshop.station.controller;

import com.pshop.station.persistence.pojo.Usuario;
import com.pshop.station.model.ErrorService;
import com.pshop.station.service.EnviarEmailService;
import com.pshop.station.service.PropertyService;
import com.pshop.station.service.UsuarioService;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/password")
public class PasswordController {
	
	private final String EMAIL_SYSTEM = "com.bstore.mail.app.bcc";
	
	@Autowired
	EnviarEmailService enviarEmailService;
	
	@Autowired
	private PropertyService propertyService;
	
    private final Logger log = Logger.getLogger(PasswordController.class);
 
    @RequestMapping(value="/recuperar", method = RequestMethod.GET)
    public String recuperarPassword(Model model){
        model.addAttribute("menu","smenu");
        return "password";
    }
    
    @RequestMapping(value="/enviar/email", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> enviarPasswordEmail(Model model, HttpServletRequest request){
        String email = request.getParameter("email");
        String confEmail = request.getParameter("confEmail");
        HttpStatus status = HttpStatus.NOT_FOUND;
        this.log.info(" -- Request recibido emai: "+email);
        this.log.info(" -- Request recibido emai: "+confEmail);
        
        ErrorService response = new ErrorService();
        Usuario user = this.usuarioService.validaEmailSistema(email);
        if(user!=null){
            this.log.info(" -- Enviar email de password a usuario: "+user.getNombre());
            response.setCodigo("202");
            response.setMensaje("Hola "+user.getNombre()+", tu password ha sido enviado a: "+user.getEmail());
            status = HttpStatus.OK;
            
            try
            {
                this.enviarEmailService.enviarRecuperacionPassword(this.propertyService.getValueKey(EMAIL_SYSTEM).getValue(),user);
                this.log.info(" -- El correo fue enviado con tu password a: " + email);
            }catch(Exception ex){
                 response.setCodigo("404");
                 response.setMensaje("Por el momento no se pudo enviar tu password a tu correo, intenta más tarde.");
                 status = HttpStatus.NOT_FOUND;
                 this.log.info(" -- El password no pudo ser enviado por el sistema");    
            }
            
        }else{
            this.log.info(" -- Este email no esta registrado en el sistema");
            response.setCodigo("404");
            response.setMensaje("Este email "+email+" no ha sido registrado en el sistema.");
        }
        return new ResponseEntity<ErrorService>(response,status);
    }
    
    @Autowired
    private UsuarioService usuarioService;
    
}
