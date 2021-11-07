package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;
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
public class ControladorResenia {

    private ServicioResenia servicioResenia;

    @Autowired
    public ControladorResenia(ServicioResenia servicioResenia){
        this.servicioResenia = servicioResenia;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-reseniar", params={"idProf"})
    public ModelAndView irAReseniar(@RequestParam Long idProf, HttpServletRequest request){

        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        long idUsuario = (Long) request.getSession().getAttribute("userID");

        Usuario usuario = servicioResenia.buscarUsuario(idProf);
        model.put ("profesional", usuario);
        DatosResenia datos = new DatosResenia();
        model.put("datosResenia", datos);


        return new ModelAndView("reseniaForm",model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrarResenia")
    public ModelAndView registrarResenia(@ModelAttribute("datosResenia") DatosResenia datos, HttpServletRequest request){

        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");
        datos.setIdUsuarioCliente(idUsuario);


        if (datos.getCalificacion()<1 || datos.getCalificacion()>10){
            String msgError = "Califique con un numero del 1 al 10";
            model.put("msgError", msgError);
            return new ModelAndView("reseniaForm", model);
        }
        if (datos.getComentario().length()<5){
            String msgError = "Escriba un comentario de mas de 5 caracteres";
            model.put("msgError", msgError);
            return new ModelAndView("reseniaForm", model);
        }
        servicioResenia.registrarResenia(datos);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-resenias-profesional")
    public ModelAndView verReseniasProfesional(HttpServletRequest request){
        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");

        List<ReseniaAProfesional> reseniaAProfesionals = servicioResenia.buscarReseniasPorIdProfesional(idUsuario);

        Usuario usuario = servicioResenia.buscarUsuario(idUsuario);

        model.put("resenias", reseniaAProfesionals);
        model.put("usuario", usuario);

        return new ModelAndView("mis-resenias-profesional", model);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-reseniar-cliente", params={"idCli"})
    public ModelAndView irAReseniarCliente(@RequestParam Long idCli, HttpServletRequest request){

        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        long idUsuario = (Long) request.getSession().getAttribute("userID");

        Usuario usuario = servicioResenia.buscarUsuario(idCli);
        model.put ("cliente", usuario);
        DatosResenia datos = new DatosResenia();
        model.put("datosResenia", datos);


        return new ModelAndView("reseniaAClienteForm",model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrarReseniaACliente")
    public ModelAndView registrarReseniaACliente(@ModelAttribute("datosResenia") DatosResenia datos, HttpServletRequest request){

        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");
        datos.setIdUsuarioProfesional(idUsuario);


        if (datos.getCalificacion()<1 || datos.getCalificacion()>10){
            String msgError = "Califique con un numero del 1 al 10";
            model.put("msgError", msgError);
            return new ModelAndView("reseniaForm", model);
        }
        if (datos.getComentario().length()<5){
            String msgError = "Escriba un comentario de mas de 5 caracteres";
            model.put("msgError", msgError);
            return new ModelAndView("reseniaForm", model);
        }
        servicioResenia.registrarReseniaACliente(datos);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-resenias-cliente")
    public ModelAndView verReseniasCliente(HttpServletRequest request){
        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");

        List<ReseniaACliente> resenias = servicioResenia.buscarReseniasAClientePorIdCliente(idUsuario);

        Usuario usuario = servicioResenia.buscarUsuario(idUsuario);

        model.put("resenias", resenias);
        model.put("usuario", usuario);

        return new ModelAndView("mis-resenias-cliente", model);

    }

}
