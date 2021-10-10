package ar.edu.unlam.tallerweb1.controladores;



import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesional;
import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesionalImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ControladorPerfilProfesional {

    private ServicioPerfilProfesional servicioPerfilProfesional;

    @Autowired
    public ControladorPerfilProfesional(ServicioPerfilProfesional servicioPerfilProfesional){
        this.servicioPerfilProfesional= servicioPerfilProfesional;
    }

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

        try {
            servicioPerfilProfesional.registrarPerfil(datos.getNombreCompleto(), datos.getEmail(),
                    datos.getExperiencia(), datos.getNumeroTelefono());
        } catch (Exception e){
            model.put("msg", "No se pudo registrar, creo");
        }

        model.put("msg", "Se pudo registrar, creo");

       return new ModelAndView("registroProfesional", model);
    }

    public ModelAndView mostrarPerfilProfesional(){

        ModelMap model = new ModelMap();
        return new ModelAndView("cv", model);
    }



}
