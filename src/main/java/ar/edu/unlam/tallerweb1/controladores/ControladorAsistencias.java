package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioService;
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

    @Inject private ServicioService servicioService;
    @Inject private RepositorioAsistencia repositorioAsistencia;

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias")
    public ModelAndView MostrarServicios(){

        ModelMap model = new ModelMap();


        model.put("servicio2", "Cuidado de ancianos por mes");
        model.put("servicio3", "Cuidado de enfermos por día");

       /* List<String> asistencias = new ArrayList<>();
        asistencias.add("Servicio 1");
        asistencias.add("Servicio 2");
        asistencias.add("Servicio 3");
        asistencias.add("Servicio 4");*/

        List <Asistencia> asistencias = repositorioAsistencia.buscarTodasLasAsistencias();

        model.put("servicio", asistencias);


        return new ModelAndView("asistencias", model);

    }

}
