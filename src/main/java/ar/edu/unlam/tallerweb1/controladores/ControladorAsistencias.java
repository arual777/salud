package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ControladorAsistencias {

    @Inject private ServicioAsistencia servicioAsistencia;
    //@Inject private RepositorioAsistencia repositorioAsistencia;

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

    public ModelAndView crearServicio(DatosAsistencia datos) {
        return null;
    }
}
