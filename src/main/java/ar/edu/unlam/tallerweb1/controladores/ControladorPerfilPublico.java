package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesional;
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
public class ControladorPerfilPublico {
    private ServicioResenia servicioResenia;
    private ServicioPerfilProfesional servicioPerfilProfesional;

    @Autowired
    public ControladorPerfilPublico(ServicioResenia servicioResenia, ServicioPerfilProfesional servicioPerfilProfesional){
        this.servicioResenia = servicioResenia;
        this.servicioPerfilProfesional = servicioPerfilProfesional;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-perfil-publico-profesional", params={"idProf"})
    public ModelAndView verPerfilPublicoProfesional(@RequestParam Long idProf, HttpServletRequest request){

        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idRol = (Long) request.getSession().getAttribute("rolID");
        model.put("idRol", idRol);

        List<ReseniaAProfesional> resenias = servicioResenia.buscarReseniasPorIdProfesional(idProf);
        Usuario usuario = servicioResenia.buscarUsuario(idProf);

        int calificacion=0;String mensaje="";
        for (int i=0; i < resenias.size(); i++){
            ReseniaAProfesional resenia = resenias.get(i);
            calificacion = calificacion + resenia.getCalificacion();
        }
        if (resenias.size()==0){
            mensaje = "(Este usuario aún no tiene resenias)";
        }else {
            calificacion = calificacion / resenias.size();
        }
        PerfilProfesional perfilProfesional = servicioPerfilProfesional.buscarCVPorIdUsuario(idProf);

        model.put("cv", perfilProfesional);
        model.put("resenias", resenias);
        model.put("usuario", usuario);
        model.put("calificacion", calificacion);
        model.put("mensaje", mensaje);

        return new ModelAndView("perfilPublicoProfesional", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-perfil-publico-cliente", params={"idCli"})
    public ModelAndView verPerfilPublicoCliente(@RequestParam Long idCli, HttpServletRequest request){

        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idRol = (Long) request.getSession().getAttribute("rolID");
        model.put("idRol", idRol);

        List<ReseniaACliente> resenias = servicioResenia.buscarReseniasAClientePorIdCliente(idCli);
        if (resenias==null){
            String msg = "Ups, parece que el usuario no existe";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        Usuario usuario = servicioResenia.buscarUsuario(idCli);

        if (usuario==null){
            String msg = "Ups, parece que el usuario no existe";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        int calificacion=0;String mensaje="";
        for (int i=0; i < resenias.size(); i++){
            ReseniaACliente resenia = resenias.get(i);
            calificacion = calificacion + resenia.getCalificacion();
        }
        if (resenias.size()==0){
            mensaje = "(Este usuario aún no tiene resenias)";
        }else {
            calificacion = calificacion / resenias.size();
        }

        model.put("resenias", resenias);
        model.put("usuario", usuario);
        model.put("calificacion", calificacion);
        model.put("mensaje", mensaje);

        return new ModelAndView("perfilPublicoCliente", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-mi-perfil-publico-profesional")
    public ModelAndView verMiPerfilPublicoProfesional(HttpServletRequest request){

        ModelMap model = new ModelMap();
        long idProf= (long) request.getSession().getAttribute("userID");
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idRol = (Long) request.getSession().getAttribute("rolID");
        model.put("idRol", idRol);

        List<ReseniaAProfesional> resenias = servicioResenia.buscarReseniasPorIdProfesional(idProf);
        Usuario usuario = servicioResenia.buscarUsuario(idProf);

        int calificacion=0;String mensaje="";
        for (int i=0; i < resenias.size(); i++){
            ReseniaAProfesional resenia = resenias.get(i);
            calificacion = calificacion + resenia.getCalificacion();
        }
        if (resenias.size()==0){
            mensaje = "(Este usuario aún no tiene resenias)";
        }else {
            calificacion = calificacion / resenias.size();
        }

        PerfilProfesional perfilProfesional = servicioPerfilProfesional.buscarCVPorIdUsuario(idProf);

        model.put("cv", perfilProfesional);
        model.put("resenias", resenias);
        model.put("usuario", usuario);
        model.put("calificacion", calificacion);
        model.put("mensaje", mensaje);

        return new ModelAndView("perfilPublicoProfesional", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-mi-perfil-publico-cliente")
    public ModelAndView verMiPerfilPublicoCliente(HttpServletRequest request){

        ModelMap model = new ModelMap();
        long idCli= (long) request.getSession().getAttribute("userID");
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idRol = (Long) request.getSession().getAttribute("rolID");
        model.put("idRol", idRol);

        List<ReseniaACliente> resenias = servicioResenia.buscarReseniasAClientePorIdCliente(idCli);
        if (resenias==null){
            String msg = "Ups, parece que el usuario no existe";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        Usuario usuario = servicioResenia.buscarUsuario(idCli);

        if (usuario==null){
            String msg = "Ups, parece que el usuario no existe";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }

        int calificacion=0;String mensaje="";
        for (int i=0; i < resenias.size(); i++){
            ReseniaACliente resenia = resenias.get(i);
            calificacion = calificacion + resenia.getCalificacion();
        }
        if (resenias.size()==0){
            mensaje = "(Este usuario aún no tiene resenias)";
        }else {
            calificacion = calificacion / resenias.size();
        }

        model.put("resenias", resenias);
        model.put("usuario", usuario);
        model.put("calificacion", calificacion);
        model.put("mensaje", mensaje);

        return new ModelAndView("perfilPublicoCliente", model);
    }




}
