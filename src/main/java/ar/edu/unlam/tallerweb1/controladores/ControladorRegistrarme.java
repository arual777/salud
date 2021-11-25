package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorRegistrarme {

    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorRegistrarme(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-registrarme")
    public ModelAndView irARegistrarme(){
        ModelMap model = new ModelMap();
        DatosRegistro datos = new DatosRegistro();
      //  datos.setEmail("Ingrese email");
        model.put("datos", datos);
        return new ModelAndView("registro-usuario", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrarme")
    public ModelAndView registrarUsuario(@ModelAttribute("datos") DatosRegistro datos) {

        ModelMap model = new ModelMap();
        Integer mensaje = null;
        if (esValido(datos.getEmail())) {

            try {
                servicioLogin.registrar(datos.getEmail(), datos.getClave(), datos.getRolId());
            } catch (Exception e) {
                mensaje = 0;
                model.put("msg", "El usuario ya existe");
                model.put("mensaje", mensaje);

                return new ModelAndView("registro-usuario", model);
            }
            mensaje = 1;
            model.put("email", datos.getEmail());
            model.put("msg", "Registro Exitoso");

            DatosLogin datosLogin = new DatosLogin();
            datosLogin.setEmail(datos.getEmail());
            model.put("datosLogin", datosLogin);
            model.put("mensaje", mensaje);

            return new ModelAndView("redirect:/login", model);
        }
        mensaje = 0;
        model.put("msg", "Registro Fallido por mail incorrecto");
        model.put("mensaje", mensaje);

        return new ModelAndView("registro-usuario", model);
    }

    private boolean esValido(String email) {
        return email.endsWith(".com") && email.contains("@");
    }
}
