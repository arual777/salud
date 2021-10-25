package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorResenia {

    private ServicioResenia servicioResenia;

    @Autowired
    public ControladorResenia(ServicioResenia servicioResenia){
        this.servicioResenia = servicioResenia;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-reseniar")
    public ModelAndView irAReseniar(HttpServletRequest request){

        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");


        DatosResenia datos = new DatosResenia();
        model.put("datosResenia", datos);

        return new ModelAndView("reseniaForm",model);

    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrarResenia")
    public ModelAndView registrarResenia(@ModelAttribute("datosResenia") DatosResenia datos, HttpServletRequest request){

        ModelMap model = new ModelMap();

        long idUsuario = (Long) request.getSession().getAttribute("userID");

        datos.setIdUsuarioCliente(idUsuario);

        servicioResenia.registrarResenia(datos);

        return new ModelAndView("reseniaForm", model);

    }

}
