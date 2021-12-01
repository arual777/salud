package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.servicios.ServicioContacto;
import ar.edu.unlam.tallerweb1.utils.SMTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorContacto {

    private ServicioAsistencia servicioAsistencia;
    private ServicioContacto servicioContacto;

    @Autowired
    public ControladorContacto(ServicioAsistencia servicioAsistencia, ServicioContacto servicioContacto){
        this.servicioAsistencia = servicioAsistencia;
        this.servicioContacto = servicioContacto;
    }

    @RequestMapping(path = "/contactarContratar", method = RequestMethod.POST)
    public ModelAndView SendMailContactarContratar(HttpServletRequest request, @ModelAttribute("datosContacto") DatosContacto contacto) throws Exception {

        SMTP.sendMail(contacto);
        ModelMap model = new ModelMap();
        model.put("datosContacto", new DatosContacto());

        try {
            servicioContacto.GeneracionUsuarioContacto(contacto);
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("home", model);
    }

}
