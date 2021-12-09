package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.servicios.ServicioMensajeria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorMensajeria {


    private ServicioMensajeria servicioMensajeria;

    @Autowired
    public ControladorMensajeria(ServicioMensajeria servicioMensajeria){
        this.servicioMensajeria = servicioMensajeria;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-crear-pregunta")
    public ModelAndView irACrearPregunta(HttpServletRequest request){

        long idUsuario = obtenerIdUsuario(request);
       long idRol = obtenerIdRol(request);
        long idAsistencia = Long.parseLong(request.getParameter("idAsistencia"));//le pide el parametro q pasa x url
        ModelMap model = new ModelMap();
        DatosMensajeria datos = new DatosMensajeria();
        datos.setIdAsistencia(idAsistencia);
        model.put("idRol", idRol);
        model.put("idUsuario", idUsuario);
        model.put("datosMensajeria", datos);

        return new ModelAndView("pregunta", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/preguntar")
    public ModelAndView preguntar(HttpServletRequest request,  @ModelAttribute("datosMensajeria") DatosMensajeria datosMensajeria) throws Exception{
        Long idUsuario = Long.parseLong(request.getSession().getAttribute("userID").toString());
        Long idRol = obtenerIdRol(request);
        datosMensajeria.setIdUsuario(idUsuario);
        ModelMap model = new ModelMap();
        model.put("idRol", idRol);
        model.put("idUsuario", idUsuario);
        Integer mensaje = null;
        if(!(datosMensajeria).getMensaje().trim().isEmpty()) {
        servicioMensajeria.crearPregunta(datosMensajeria);
            mensaje = 1;
            model.put("msg", "Usted ha enviado un mensaje exitosamente");
        } else{
            mensaje = 0;
            model.put("msg", "Usted no ha formulado ninguna pregunta");
        }
        model.put("mensaje", mensaje);
        return new ModelAndView("empleos-publicados", model);
    }

    private Long obtenerIdUsuario(HttpServletRequest request){
        return Long.parseLong(request.getSession().getAttribute("userID").toString());
    }

    private Long obtenerIdRol(HttpServletRequest request){
        return Long.parseLong(request.getSession().getAttribute("rolID").toString());
    }

    @RequestMapping(path="/buzon", method = RequestMethod.GET)
    public ModelAndView verPreguntas(HttpServletRequest request) {
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap model = new ModelMap();
        model.put("idRol", idRol);
        List<Mensaje> preguntas = servicioMensajeria.buscarPreguntasPorUsuario(idUsuario);
        String mensaje = request.getParameter("msg");

        model.put("preguntas", preguntas);
        model.put("msg",mensaje);
        return new ModelAndView("buzon", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/responder")
    public ModelAndView responder(HttpServletRequest request,  @ModelAttribute("datosMensajeria") DatosMensajeria datosMensajeria) {
        servicioMensajeria.responder(datosMensajeria);
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("msg","Respuesta registrada");//le pasa por query string
        modelView.setViewName("redirect:/buzon");
        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, path="/respuestas")
    public ModelAndView verRespuestas(HttpServletRequest request) {
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap model = new ModelMap();
        model.put("idRol", idRol);
        List<Mensaje> preguntas = servicioMensajeria.buscarPreguntasPorUsuarioRespondidas(idUsuario);
        model.put("preguntas", preguntas);

        return new ModelAndView("casillaProfesional", model);
    }



    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/pendientes")
    public String ObtenerMensajesPendientes(HttpServletRequest request) {

    Long idUsuario = obtenerIdUsuario(request);
    Long idRol = obtenerIdRol(request);

        if (idRol == 2) {
            Boolean respuestasSinLeer = servicioMensajeria.tieneRespuestasSinLeer(idUsuario);
            String mensajesNuevos = "0";
        if(respuestasSinLeer == true){
                mensajesNuevos = "Correo nuevo";
            }
        return mensajesNuevos;
        }

        List<Mensaje> mensajes = servicioMensajeria.buscarPreguntasPorUsuario(idUsuario);
        String mensajesNuevos = "0";

        for (Mensaje mensaje : mensajes) {
        if (mensaje.getRespuesta() == null) {
                mensajesNuevos = "Correo nuevo";
            }
        }
        return mensajesNuevos;
    }
}
