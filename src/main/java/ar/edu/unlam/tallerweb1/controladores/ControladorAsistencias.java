package ar.edu.unlam.tallerweb1.controladores;

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

    public ControladorAsistencias() {
    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias")
    public ModelAndView MostrarServicios(){

        ModelMap model = new ModelMap();

        List <Asistencia> asistencias = servicioAsistencia.buscarTodasLasAsistencias();

        model.put ("titulo", "Todos los servicios");
        model.put("empleo", asistencias);
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

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.GET)
    public ModelAndView eliminarSolicitudDeEmpleo(@ModelAttribute("id") Long id) throws Exception {
        ModelMap modelo = new ModelMap();
        servicioAsistencia.eliminarSolicitudDeEmpleo(id);  //ACA TIRA ERROR AL ELIMINAR

        modelo.put("mensaje", "Solicitud de empleo eliminada con exito!");

        return new ModelAndView("redirect:/ir-a-asistencias", modelo);
    }



}
