package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorAsistencias {

    private ServicioAsistencia servicioAsistencia;

    @Autowired
    public ControladorAsistencias(ServicioAsistencia servicioAsistencia){
        this.servicioAsistencia = servicioAsistencia;
    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias")
    public ModelAndView MostrarServicios(HttpServletRequest request){
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap model = new ModelMap();

        List <Asistencia> asistencias = servicioAsistencia.buscarTodasLasAsistencias();

        model.put ("titulo", "Todos los servicios");
        model.put("empleos", asistencias);
        model.put("idRol", idRol);
        return new ModelAndView("empleos-publicados", model);

    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias-diarias")
    public ModelAndView MostrarServiciosDiarios(){

        ModelMap model = new ModelMap();

        List <Asistencia> asistencias = servicioAsistencia.buscarAsistenciasPorDia();

        model.put ("titulo", "Servicios Diarios");
        model.put("servicio", asistencias);


        return new ModelAndView("asistencias", model);

    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias-mensuales")
    public ModelAndView MostrarServiciosMensuales(){

        ModelMap model = new ModelMap();

        List <Asistencia> asistencias = servicioAsistencia.buscarAsistenciasMensuales();

        model.put ("titulo", "Servicios Mensuales");
        model.put("servicio", asistencias);

        return new ModelAndView("asistencias", model);
    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias-por-zona-oeste")
    public ModelAndView MostrarServiciosPorZona(){

        ModelMap model = new ModelMap();
        Long idZona = 5L;
        List <Asistencia> asistencias = servicioAsistencia.buscarAsistenciasPorZona(idZona);

        model.put ("titulo", "Servicios por Zona");
        model.put("empleos", asistencias);


        return new ModelAndView("asistencias", model);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-crear-solicitud")
    public ModelAndView irACrearSolicitud(){
        ModelMap model = new ModelMap();
        DatosAsistencia datos = new DatosAsistencia();

        model.put("datos", datos);
        return new ModelAndView("solicitudNueva", model);
    }

    @RequestMapping (method = RequestMethod.POST, path = "/crearSolicitud")
    public ModelAndView crearNuevaSolicitudDeAsistencia(HttpServletRequest request, @ModelAttribute("datos") DatosAsistencia datos) {

        Long idUsuario = Long.parseLong(request.getSession().getAttribute("userID").toString());
        datos.setIdUsuario(idUsuario);
        servicioAsistencia.crearServicio(datos);

        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("redirect:/ir-a-asistencias");
        return modelView;
    }

    @RequestMapping (method = RequestMethod.POST, path = "/editarSolicitud")
    public ModelAndView editar(@ModelAttribute("asistencia") DatosAsistencia datos) throws Exception {
        servicioAsistencia.actualizarAsistencia(datos);
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("redirect:/ir-a-asistencias");
        return modelView;
    }

    @RequestMapping (method = RequestMethod.GET, path = "/detalle-asistencia/{idAsistencia}")
    public ModelAndView buscarAsistenciaPorId(@PathVariable("idAsistencia") long idAsistencia) throws Exception {

        ModelMap model = new ModelMap();
        Asistencia asistenciaBuscada  =servicioAsistencia.buscarAsistenciaPorId(idAsistencia);
        model.put("asistencia", asistenciaBuscada);

        return new ModelAndView("detalle-solicitud", model);
    }

    @RequestMapping (method = RequestMethod.GET, path = "/detalle-asistencia/{nombre}")
    public ModelAndView buscarAsistenciaPorNombreEspecifico(@PathVariable("nombre") String nombre) throws Exception {

        ModelMap model = new ModelMap();
        Asistencia asistenciaBuscada  =servicioAsistencia.buscarAsistenciaPorNombreEspecifico(nombre);
        model.put("asistencia", asistenciaBuscada);

        return new ModelAndView("detalle-solicitud", model);
    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.GET)
    public ModelAndView eliminarSolicitudDeEmpleo(@ModelAttribute("id") Long id) throws Exception {
        ModelMap modelo = new ModelMap();
        servicioAsistencia.eliminarSolicitudDeEmpleo(id);

        modelo.put("mensaje", "Solicitud de empleo eliminada con exito!");

        return new ModelAndView("redirect:/ir-a-asistencias", modelo);
    }

    @RequestMapping(path="/postularme", method=RequestMethod.POST)
    public ModelAndView postularmeAEmpleo(HttpServletRequest request, @ModelAttribute("datosPostulacion") DatosPostulacion datosPostulacion) throws Exception {

        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);

        ModelMap modelo = new ModelMap();
        try {
        datosPostulacion.setIdUsuario(idUsuario);
        servicioAsistencia.crearPostulacion(datosPostulacion);
        modelo.put("msg", "Usted se ha postulado exitosamente");
        List <Postulacion> postulaciones = servicioAsistencia.buscarPostulacionesPorUsuario(idUsuario);
        modelo.put("idRol", idRol);
        modelo.put ("titulo", "Mis postulaciones");
        modelo.put("postulaciones", postulaciones);

        } catch (Exception e){
            modelo.put("msg", "No puede postularse por segunda vez");
        }

        return new ModelAndView("postulaciones",modelo);
    }

    private Long obtenerIdUsuario(HttpServletRequest request){
        return Long.parseLong(request.getSession().getAttribute("userID").toString());
    }

    private Long obtenerIdRol(HttpServletRequest request){
        return Long.parseLong(request.getSession().getAttribute("rolID").toString());
    }

}
