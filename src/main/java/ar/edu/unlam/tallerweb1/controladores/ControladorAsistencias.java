package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ControladorAsistencias {

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias")
    public ModelAndView MostrarServicios(){

        ModelMap model = new ModelMap();

        //funcion del servicio Función(servicio lo que haria: Buscar "Asistencias" en la bd y traerlas.)

        //Controller: Usa servicio (Que busca asistencias en este caso), hace pequeña lógica, y envia a la
        //vista.

        /*model.put("servicio",  "Cuidado de ancianos por día2");
        model.put("servicio",  "Cuidado de ancianos por día3");
        model.put("servicio",  "Cuidado de ancianos por día4");*/
        model.put("servicio2", "Cuidado de ancianos por mes");
        model.put("servicio3", "Cuidado de enfermos por día");

        List<String> asistencias = new ArrayList<>();
        asistencias.add("Servicio 1");
        asistencias.add("Servicio 2");
        asistencias.add("Servicio 3");
        asistencias.add("Servicio 4");

        model.put("servicio", asistencias);


        return new ModelAndView("asistencias", model);

    }

}
