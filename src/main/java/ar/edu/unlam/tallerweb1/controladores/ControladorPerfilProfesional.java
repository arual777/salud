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
import java.util.List;


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

        logeado = "siLogeado";
        DatosRegistroProfesional datos = new DatosRegistroProfesional();
        model.put("datosRegistroProfesional", datos);

        model.put("msglogeado", logeado);
        return new ModelAndView("registroProfesional", model);

    }


    @RequestMapping(method = RequestMethod.POST, path = "/registroProfesional")
    public ModelAndView registroPerfilProfesional(@ModelAttribute("datosRegistroProfesional") DatosRegistroProfesional datos, HttpServletRequest request) {

        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msgSesion = "No ingresaste en el sistema";
            model.put("msglogeado", msgSesion);
            return new ModelAndView("errorAcceso", model);
        }

        long idUsuario = (Long) request.getSession().getAttribute("userID");
        try {
            servicioPerfilProfesional.registrarPerfil(datos.getNombreCompleto(), datos.getEmail(),
                    datos.getExperiencia(), datos.getNumeroTelefono(), datos.getFechaNacimiento(), idUsuario);

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

    @RequestMapping (method = RequestMethod.GET, path = "/ver-todos-perfiles-profesionales")
    public ModelAndView mostrarTodosPerfilProfesional(HttpServletRequest request){

        ModelMap model = new ModelMap();

        if (request.getSession().getAttribute("userID")==null) {
            String msgSesion = "No ingresaste en el sistema";
            model.put("msglogeado", msgSesion);
            return new ModelAndView("errorAcceso", model);
        }

        List<PerfilProfesional> perfilProfesionalList = servicioPerfilProfesional.buscarTodos();
        model.put("cvs", perfilProfesionalList);
        return new ModelAndView("verTodosPerfilProfesional", model);

    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-editar-perfil-profesional", params={"id"} )
    public ModelAndView irAEditarPerfilProfesional(@RequestParam Long id, @ModelAttribute ("datosRegistroProfesional") DatosRegistroProfesional datos, HttpServletRequest request){

        if (request.getSession().getAttribute("userID")==null) {
            ModelMap model = new ModelMap();
            String msgSesion = "No ingresaste en el sistema";
            model.put("msglogeado", msgSesion);
            return new ModelAndView("errorAcceso", model);
        }

        PerfilProfesional perfilProfesional = servicioPerfilProfesional.buscarCV(id);

        if (request.getSession().getAttribute("userID").equals(perfilProfesional.getIdUsuario())) {
            ModelMap model = new ModelMap();
            model.put("curriculum", perfilProfesional);
            return new ModelAndView("editarPerfilProfesional", model);
        }

        return new ModelAndView("errorAcceso");

    }

    @RequestMapping (method = RequestMethod.POST, path = "/editarPerfilProfesional")
    public ModelAndView editarPerfilProfesional(@ModelAttribute ("datosRegistroProfesional") DatosRegistroProfesional datos, HttpServletRequest request){
        ModelAndView modelView = new ModelAndView();


        if (request.getSession().getAttribute("userID").equals(datos.getId())) {
            servicioPerfilProfesional.editarPerfil(datos);
            modelView.setViewName("redirect:/ver-todos-perfiles-profesionales");
            return modelView;
        }
        else{
            return new ModelAndView("errorAcceso");
        }

    }


}
