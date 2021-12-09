package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-asistencias")
    public ModelAndView MostrarServicios(HttpServletRequest request){
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap model = new ModelMap();
        Integer mensaje = null;
        model.put ("titulo", "Todos los servicios");

        try{
            List <Asistencia> asistencias = servicioAsistencia.buscarTodasLasAsistencias();
            mensaje = 1;
            model.put("empleos", asistencias);
            model.put("idRol", idRol);
            model.put("msg", "Estos son los empleos");

        }catch(Exception e){
            mensaje = 0;
            model.put("msg", "No tiene empleos para ver");
        }
        model.put("mensaje", mensaje);
        return new ModelAndView("empleos-publicados", model);
    }

    @RequestMapping (method = RequestMethod.GET, path = "/ir-a-mis-asistencias")
    //mostrar solo mis empleos que no tienen postulantes
    public ModelAndView mostrarMisEMpleos(HttpServletRequest request){
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap model = new ModelMap();
        Integer mensaje = null;
        try {

            List <Asistencia> asistencias = servicioAsistencia.buscarAsistenciasSinPostulantes(idUsuario);


            if(asistencias.isEmpty()){
                mensaje = 0;
                model.put("msg", "Usted no tiene empleos creados");
            }else{
                mensaje = 1;
                model.put("msg", "Estos son sus empleos creados sin postulados");
            }
            model.put ("titulo", "Todos mis servicios");
            model.put("empleos", asistencias);
            model.put("idRol", idRol);
            model.put("idUsuario", idUsuario);
        } catch(Exception e){
            mensaje = 0;
            model.put("msg", "No tiene empleos para ver");
        }
        model.put("mensaje", mensaje);
        return new ModelAndView("mis-empleos", model);
    }

    @RequestMapping (method = RequestMethod.GET, path = "/historial")
    public ModelAndView historial(HttpServletRequest request){
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap model = new ModelMap();
        Integer mensaje = null;
        try {
            List <Asistencia> asistencias = servicioAsistencia.buscarAsistenciaPorIdDelCliente(idUsuario);
            if(asistencias.isEmpty()){
                mensaje = 0;
                model.put("msg", "Usted no tiene empleos creados");
            }else{
                mensaje = 1;
                model.put("msg", "Este es su historial de empleos creados");
            }
            model.put ("titulo", "Todos mis servicios");
            model.put("empleos", asistencias);
            model.put("idRol", idRol);
        } catch(Exception e){
            mensaje = 0;
            model.put("msg", "No tiene empleos para ver");
        }
        model.put("mensaje", mensaje);
        return new ModelAndView("historial", model);
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
    public ModelAndView irACrearSolicitud(HttpServletRequest request){

        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);

        ModelMap model = new ModelMap();
        DatosAsistencia datos = new DatosAsistencia();
        model.put("idRol", idRol);
        model.put("datos", datos);
        return new ModelAndView("solicitudNueva", model);
    }

    @RequestMapping (method = RequestMethod.POST, path = "/crearSolicitud")
    public ModelAndView crearNuevaSolicitudDeAsistencia(HttpServletRequest request, @ModelAttribute("datos") DatosAsistencia datos) {

        Long idUsuario = Long.parseLong(request.getSession().getAttribute("userID").toString());
        datos.setIdUsuario(idUsuario);
        servicioAsistencia.crearServicio(datos);

        ModelAndView modelView = new ModelAndView();

        modelView.setViewName("redirect:/ir-a-mis-asistencias");
        return modelView;
    }


    @RequestMapping (method = RequestMethod.POST, path = "/editarSolicitud")
    public ModelAndView editar(HttpServletRequest request, @ModelAttribute("asistencia") DatosAsistencia datos) throws Exception {
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);

        servicioAsistencia.actualizarAsistencia(datos);
        ModelMap model = new ModelMap();
        model.put("idRol", idRol);

        return new ModelAndView("redirect:/ir-a-mis-asistencias", model);

    }

    @RequestMapping (method = RequestMethod.GET, path = "/detalle-asistencia/{idAsistencia}")
    public ModelAndView buscarAsistenciaPorId(HttpServletRequest request, @PathVariable("idAsistencia") long idAsistencia) throws Exception {
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);

         ModelMap model = new ModelMap();
        Asistencia asistenciaBuscada  =servicioAsistencia.buscarAsistenciaPorId(idAsistencia);
        model.put("asistencia", asistenciaBuscada);
        model.put("idRol", idRol);

        return new ModelAndView("detalle-solicitud-sin-editar", model);
    }
/*
    al tener el mismo path que detalle-asistencia/{idAsistencia} , cuando se edita la asistencia se rompe.
    hay que cambiar el path de este metodo
    @RequestMapping (method = RequestMethod.GET, path = "/detalle-asistencia/{nombre}")
    public ModelAndView buscarAsistenciaPorNombreEspecifico(@PathVariable("nombre") String nombre) throws Exception {

        ModelMap model = new ModelMap();
        Asistencia asistenciaBuscada  =servicioAsistencia.buscarAsistenciaPorNombreEspecifico(nombre);
        model.put("asistencia", asistenciaBuscada);

        return new ModelAndView("detalle-solicitud", model);
    }
*/
    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.GET)
    public ModelAndView eliminarSolicitudDeEmpleo(@ModelAttribute("id") Long id) throws Exception {
        ModelMap modelo = new ModelMap();
        servicioAsistencia.eliminarSolicitudDeEmpleo(id);
     //!!
        modelo.put("mensaje", "Solicitud de empleo eliminada con exito!");

        return new ModelAndView("redirect:/ir-a-asistencias", modelo);
    }

    @RequestMapping(path="/postularme", method=RequestMethod.POST)
    public ModelAndView postularmeAEmpleo(HttpServletRequest request, @ModelAttribute("datosPostulacion") DatosPostulacion datosPostulacion) throws Exception {

        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        Integer mensaje = null;
        ModelMap modelo = new ModelMap();
        try {
            mensaje = 1;
            datosPostulacion.setIdUsuario(idUsuario);
            servicioAsistencia.crearPostulacion(datosPostulacion);
            modelo.put("msg", "Usted se ha postulado exitosamente");
            List <Postulacion> postulaciones = servicioAsistencia.buscarPostulacionesPorUsuario(idUsuario);
            modelo.put("idRol", idRol);
            modelo.put ("titulo", "Mis postulaciones");
            modelo.put("postulaciones", postulaciones);

        } catch (Exception e){
            mensaje = 0;
            modelo.put("idRol", idRol);
            modelo.put("msg", "No puede postularse por segunda vez");
        }
        modelo.put("mensaje", mensaje);

        return new ModelAndView("postulaciones",modelo);
    }

    @RequestMapping(path="/ver-postulados", method=RequestMethod.GET)
    public ModelAndView verPostulados(HttpServletRequest request, @ModelAttribute("datosPostulacion") DatosPostulacion datosPostulacion) throws Exception {

        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);

        ModelMap modelo = new ModelMap();
        Integer mensaje;
        try {
            List <Postulacion> postulaciones = servicioAsistencia.buscarPostulacionesPorCreadorNoAceptados(idUsuario);
            if(postulaciones.isEmpty()){
                mensaje = 0;
                modelo.put("msg", "Usted no tiene postulados para contratar");
            }else{
                mensaje = 1;
                modelo.put("msg", "Estos son los postulantes");
            }
            modelo.put("idRol", idRol);
            modelo.put("titulo", "Postulados");
            modelo.put("postulaciones", postulaciones);
       } catch(Exception e){
            mensaje = 0;
            modelo.put("msg", "No tiene postulados para ver");
        }
        modelo.put("mensaje", mensaje);

        return new ModelAndView("postulaciones",modelo);
    }

    @RequestMapping(path="/ver-postulaciones", method=RequestMethod.GET)
    public ModelAndView verPostulaciones(HttpServletRequest request){
        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        ModelMap modelo = new ModelMap();
        Integer mensaje;
        try {
            List <Postulacion> postulaciones = servicioAsistencia.buscarPostulacionesPorUsuario(idUsuario);
            if(postulaciones.isEmpty()){
                mensaje = 0;
                modelo.put("msg", "Usted no ha realizado ninguna postulación");
            }else{
                mensaje = 1;
                modelo.put("msg", "Estas son sus postulaciones");
            }
            modelo.put("idRol", idRol);
            modelo.put("titulo", "Postulaciones");
            modelo.put("postulaciones", postulaciones);
        } catch(Exception e){
            mensaje = 0;
            modelo.put("msg", "No tiene postulaciones para ver");
        }
        modelo.put("mensaje", mensaje);

        return new ModelAndView("postulaciones",modelo);
    }

    @RequestMapping(path="/contratado", method=RequestMethod.POST)
    public ModelAndView contratarPostulado(HttpServletRequest request, @ModelAttribute("datosPostulacion") DatosPostulacion datosPostulacion) throws Exception {

        Long idUsuario = obtenerIdUsuario(request);
        Long idRol = obtenerIdRol(request);
        Integer mensaje = null;
        ModelMap modelo = new ModelMap();
        try {
            Postulacion postulacionElegida = servicioAsistencia.actualizarPostulacionContratada(datosPostulacion);
            modelo.put("idRol", idRol);
            modelo.put ("titulo", "Contratado");
            //modelo.put("postulaciones", postulacionElegida);
            mensaje = 1;
            modelo.put("msg", "Usted ha contratado a " + postulacionElegida.getProfesional().getEmail() + " para la asistencia " + postulacionElegida.getAsistencia().getDescripcion());
        } catch (Exception e){
            mensaje = 0;
            modelo.put("msg", "No puede contratarlo");
        }
        modelo.put("mensaje", mensaje);

        return new ModelAndView("contratado",modelo);
    }

    private Long obtenerIdUsuario(HttpServletRequest request){
        return Long.parseLong(request.getSession().getAttribute("userID").toString());
    }

    private Long obtenerIdRol(HttpServletRequest request){
        return Long.parseLong(request.getSession().getAttribute("rolID").toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ver-ubicacion-empleo", params={"empleo"})
    public ModelAndView verUbicacionEmpleo(HttpServletRequest request, @RequestParam Long empleo) throws Exception{
        ModelMap model = new ModelMap();
        long idRol = (Long) request.getSession().getAttribute("rolID");
        if (request.getSession().getAttribute("userID")==null){
            String msg = "No ingresaste en el sistema";
            model.put("msglogeado", msg);
            return new ModelAndView("errorAcceso", model);
        }
        Asistencia asistenciaBuscada  =servicioAsistencia.buscarAsistenciaPorId(empleo);
        model.put("idRol", idRol);
        model.put("empleo", asistenciaBuscada);
        return new ModelAndView("ubicacionEmpleo", model);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/buscarEmpleos")
    public ModelAndView buscarEmpleos(HttpServletRequest request) throws Exception{
        String zona =  request.getParameter("zona");
        String turno = request.getParameter("turno");
        String camaAdentro = request.getParameter("camaAdentro");
        ModelMap model = new ModelMap();
        DatosFiltro datosFiltro = new DatosFiltro();

        if(!zona.equals("TODOS")) {
            long idZona= Long.parseLong(zona);
            datosFiltro.setIdZona(idZona);
        }

        if(!turno.equals("TODOS")) {
            long idTurno= Long.parseLong(turno);
            datosFiltro.setIdTurno(idTurno);
        }

        if(!camaAdentro.equals("TODOS")){
            boolean adentro = camaAdentro.equals("1") ? true :false;
            datosFiltro.setCamaAdentro(adentro);
        }

        Long idRol = obtenerIdRol(request);
        Integer mensaje = null;
        model.put ("titulo", "Todos los servicios");
        try{
            List<Asistencia> asistencias = servicioAsistencia.buscarEmpleos(datosFiltro);
            mensaje = 1;
            model.put("msg", "Estos son los empleos");

            if(asistencias.isEmpty()){
                mensaje = 0;
                model.put("msg", "No tiene empleos para ver");
            }

            model.put("hZona",zona);
            model.put("hCama",camaAdentro);
            model.put("hTurno",turno);
            model.put("empleos", asistencias);
            model.put("idRol", idRol);

        }catch(Exception e){
            mensaje = 0;
            model.put("msg", "No tiene empleos para ver");
        }
        model.put("mensaje", mensaje);
        return new ModelAndView("empleos-publicados", model);
    }


}
