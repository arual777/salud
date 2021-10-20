package ar.edu.unlam.tallerweb1.controladores;



import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesional;
import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesionalImpl;
import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorPerfilProfesional {

    private ServicioPerfilProfesional servicioPerfilProfesional;

    @Autowired
    public ControladorPerfilProfesional(ServicioPerfilProfesional servicioPerfilProfesional){
        this.servicioPerfilProfesional= servicioPerfilProfesional;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-registrar-perfil-profesional")
    public ModelAndView irARegistrarPerfilProfesional(HttpServletRequest request){

        ModelMap model = new ModelMap();
        String logeado;

        if (request.getSession().getAttribute("userID")==null){
            logeado = "No ingresaste en el sistema";
            model.put("msglogeado", logeado);
            return new ModelAndView("errorAcceso", model);
        }
        else{
            logeado = "siLogeado";
            DatosRegistroProfesional datos = new DatosRegistroProfesional();
            model.put("datosRegistroProfesional", datos);

            model.put("msglogeado", logeado);
            return new ModelAndView("registroProfesional", model);
        }
    }


    @RequestMapping(method = RequestMethod.POST, path = "/registroProfesional")
    public ModelAndView registroPerfilProfesional(@ModelAttribute("datosRegistroProfesional") DatosRegistroProfesional datos) {

        ModelMap model = new ModelMap();


        try {
            servicioPerfilProfesional.registrarPerfil(datos.getNombreCompleto(), datos.getEmail(),
                    datos.getExperiencia(), datos.getNumeroTelefono(), datos.getFechaNacimiento());

            model.put("msg", "Su perfil profesional ha sido cargado");
        } catch (Exception e){
            model.put("msg", "No se pudo registrar su perfil profesional, complete todos los campos");
        }

       return new ModelAndView("registroProfesional", model);
    }


    @RequestMapping (method = RequestMethod.GET, path = "/cv", params={"id"})
    public ModelAndView mostrarPerfilProfesional(@RequestParam Long id){

        ModelMap model = new ModelMap();

        PerfilProfesional perfilProfesional = servicioPerfilProfesional.buscarCV(id);

        model.put("curriculum", perfilProfesional);


        return new ModelAndView("cv", model);
    }


}
