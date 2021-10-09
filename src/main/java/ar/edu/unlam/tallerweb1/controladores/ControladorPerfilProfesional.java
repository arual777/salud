package ar.edu.unlam.tallerweb1.controladores;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ControladorPerfilProfesional {

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-registrar-perfil-profesional")
    public ModelAndView irARegistrarPerfilProfesional(){

        ModelMap model = new ModelMap();

        DatosRegistroProfesional datos = new DatosRegistroProfesional();
        model.put("datosRegistroProfesional", datos);

        return new ModelAndView("registroProfesional", model);

    }


    @RequestMapping(method = RequestMethod.POST, path = "/registroProfesional")
    public ModelAndView registroPerfilProfesional(@ModelAttribute("datosRegistroProfesional") DatosRegistroProfesional datos) {

        ModelMap model = new ModelMap();


        return new ModelAndView("registroProfesional", model);
    }



}
