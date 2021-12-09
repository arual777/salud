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
        long idRol = (Long) request.getSession().getAttribute("rolID");
        long idUsuario = (Long) request.getSession().getAttribute("userID");
        if (idRol!=1L){
            String msg = "No tenes permitido ver esta sección";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        Usuario usuarioProfesional = servicioResenia.buscarUsuario(idProf);
        long idUsuarioProfesional = usuarioProfesional.getId();

        List <ReseniaAProfesional> resenias = servicioResenia.buscarReseniaPorClienteYProfesional(idUsuario, idUsuarioProfesional);

        if(!resenias.isEmpty()){
            String msg = "No podes reseñar dos veces a un mismo profesional";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }


        model.put ("profesional", usuarioProfesional);
        DatosResenia datos = new DatosResenia();
        model.put("datosResenia", datos);
        model.put("idRol", idRol);

        return new ModelAndView("reseniaForm",model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrarResenia")
    public ModelAndView registrarResenia(@ModelAttribute("datosResenia") DatosResenia datos, HttpServletRequest request){

        ModelMap model = new ModelMap();

        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

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

        try {
        servicioResenia.registrarResenia(datos);
        } catch (Exception e) {
            return new ModelAndView("redirect:/errorAcceso");
        }
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-resenias-profesional")
    public ModelAndView verReseniasProfesional(HttpServletRequest request){
        ModelMap model = new ModelMap();

        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idRol = (Long) request.getSession().getAttribute("rolID");
        long idUsuario = (Long) request.getSession().getAttribute("userID");

        List<ReseniaAProfesional> reseniaAProfesionals = servicioResenia.buscarReseniasPorIdProfesional(idUsuario);


        int calificacion=0;String mensaje="";int restante=0;
        for (int i=0; i < reseniaAProfesionals.size(); i++){
            ReseniaAProfesional resenia = reseniaAProfesionals.get(i);
            calificacion = calificacion + resenia.getCalificacion();

        }
        if (reseniaAProfesionals.size()==0){
            mensaje="(Aún no tiene reseñas)";
        }else {
            calificacion = calificacion / reseniaAProfesionals.size();
            restante = 10 - calificacion;
        }
        Usuario usuario = servicioResenia.buscarUsuario(idUsuario);

        model.put("resenias", reseniaAProfesionals);
        model.put("usuario", usuario);

        model.put("calificacion", calificacion);
        model.put("restante",restante);
        model.put("mensaje", mensaje);
        model.put("idRol", idRol);

        return new ModelAndView("mis-resenias-profesional", model);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-resenias-cliente")
    public ModelAndView verReseniasCliente(HttpServletRequest request){
        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");
        long idRol = (Long) request.getSession().getAttribute("rolID");

        if (idRol!=1L){
            String msg = "No tenes permitido ver esta sección";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        List<ReseniaACliente> resenias = servicioResenia.buscarReseniasAClientePorIdCliente(idUsuario);
        
        int calificacion=0;String mensaje="";int restante = 0;
        for (int i=0; i< resenias.size(); i++){
            ReseniaACliente resenia = resenias.get(i);
            calificacion = calificacion + resenia.getCalificacion();
        }
        if(resenias.size()==0){
            mensaje="(Aún no tiene reseñas)";
        }else {
            calificacion = calificacion / resenias.size();
            restante = 10 - calificacion;
        }
        Usuario usuario = servicioResenia.buscarUsuario(idUsuario);
        model.put("resenias", resenias);
        model.put("usuario", usuario);
        model.put("calificacion", calificacion);
        model.put("restante", restante);
        model.put("mensaje", mensaje);

        return new ModelAndView("mis-resenias-cliente", model);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-reseniar-cliente", params={"idCli"})
    public ModelAndView irAReseniarCliente(@RequestParam Long idCli, HttpServletRequest request){


        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idRol = (Long) request.getSession().getAttribute("rolID");
        if (idRol==1L){
            String msg = "No tenes permitido ver esta sección";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        long idUsuario = (Long) request.getSession().getAttribute("userID");

        Usuario usuarioCliente = servicioResenia.buscarUsuario(idCli);
        long idUsuarioCliente = usuarioCliente.getId();


        List <ReseniaACliente> resenias = servicioResenia.buscarReseniaAClientePorClienteYProfesional(idUsuarioCliente, idUsuario);

        if(!resenias.isEmpty()){
            String msg = "No podes reseñar dos veces a un mismo cliente";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        model.put ("cliente", usuarioCliente);
        DatosResenia datos = new DatosResenia();
        model.put("datosResenia", datos);
        model.put("idRol", idRol);

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

        try {
        servicioResenia.registrarReseniaACliente(datos);
        } catch (Exception e) {
            return new ModelAndView("redirect:/errorAcceso");
        }
        return new ModelAndView("redirect:/home");
    }



}
