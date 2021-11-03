package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ControladorEmpleos {

    private ServicioAsistencia servicioAsistencia;

    @Autowired
    public ControladorEmpleos(ServicioAsistencia servicioAsistencia){
        this.servicioAsistencia = servicioAsistencia;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/ver-mis-empleos-coordinados")
    public ModelAndView MostrarEmpleosCoordinadosCliente(HttpServletRequest request){


        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        long idUsuario = (Long) request.getSession().getAttribute("userID");

        List<Postulacion> empleosCoordinadosList = servicioAsistencia.buscarEmpleosOfrecidosCoordinados();

        model.put("empleos", empleosCoordinadosList);


        return new ModelAndView("empleos-coordinados",model);

    }

}
