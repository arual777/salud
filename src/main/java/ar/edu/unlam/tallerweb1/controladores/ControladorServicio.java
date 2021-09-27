package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorServicio {

    private ServicioService servicioService;

    @Autowired
    public ControladorServicio(ServicioService servicioService)
    {
        this.servicioService = servicioService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-crearService")
    public ModelAndView irACrearServicio(){
        ModelMap model = new ModelMap();
        DatosServicio datos = new DatosServicio();
        model.put("datos", datos);
        return new ModelAndView("servicioNuevo", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/crearService")
    public ModelAndView crearServicio(@ModelAttribute("datos") DatosServicio datos) {
        ModelMap model = new ModelMap();
        servicioService.crearServicio(datos.getName());
        model.put("datos",datos);
        return new ModelAndView("servicioNuevo", model);
    }

}
