package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

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
        model.put("servicio", asistencias);
        return new ModelAndView("asistencias", model);

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
    public ModelAndView crearNuevaSolicitudDeAsistencia(@ModelAttribute("datos") DatosAsistencia datos) {

        ModelMap model = new ModelMap();
        servicioAsistencia.crearServicio(datos);

        model.put ("titulo", "NUEVA SOLICITUD PARA CUIDADOS");
        List <Asistencia> asistencias = servicioAsistencia.buscarTodosLosEmpleos();

        model.put ("titulo", "Todos los empleos");
        model.put("empleo", asistencias);
        return new ModelAndView("empleos-publicados", model);
    }
}
