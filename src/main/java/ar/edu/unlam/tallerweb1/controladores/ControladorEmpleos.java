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
        String mensaje = request.getParameter("msg");
        long idUsuario = (Long) request.getSession().getAttribute("userID");
        long idRol = (Long) request.getSession().getAttribute("rolID");

        ModelMap model = new ModelMap();
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";

            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        if (idRol!=1L){
            String msg = "No tenes permitido ver esta sección";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }


        List<Postulacion> empleosCoordinadosList = servicioAsistencia.buscarEmpleosOfrecidosCoordinados(idUsuario);

        model.put("empleos", empleosCoordinadosList);
        model.put("idRol", idRol);

        return new ModelAndView("empleos-coordinados",model);

    }

}
