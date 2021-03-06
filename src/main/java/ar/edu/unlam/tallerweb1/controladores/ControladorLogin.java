package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin){
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping("/index")
	public ModelAndView irAlIndex() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		modelo.put("datosContacto", new DatosContacto());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("index", modelo);
	}
	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
		Integer mensaje = null;
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("userID", usuarioBuscado.getId());
			request.getSession().setAttribute("rolID", usuarioBuscado.getRol().getId());

			long idRol = usuarioBuscado.getRol().getId();
			model.put("idRol", idRol);

			return new ModelAndView("home", model);
		} else {
			mensaje = 0;
			model.put("msg", "Usuario o clave incorrecta");
			model.put("mensaje", mensaje);

			return new ModelAndView("login", model);
		}
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(method = RequestMethod.GET, path = "/home" )
	public ModelAndView irAHome(HttpServletRequest request) {
		Long idUsuario = obtenerIdUsuario(request);
		Long idRol = obtenerIdRol(request);

		ModelMap model = new ModelMap();

		model.put("idUsuario", idUsuario);
		model.put("idRol", idRol);
		model.put("datosLogin", new DatosLogin());
		return new ModelAndView("home", model);
		//return new ModelAndView("home");
	}

	@RequestMapping(path = "/cerrar-sesion", method = RequestMethod.GET)
	public ModelAndView cerrarSession(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		ModelMap model = new ModelMap();
		model.put("datosLogin", new DatosLogin());
		model.put("datosContacto", new DatosContacto());
		return new ModelAndView("redirect:/index", model);
	}

	private Long obtenerIdUsuario(HttpServletRequest request){
		return Long.parseLong(request.getSession().getAttribute("userID").toString());
	}

	private Long obtenerIdRol(HttpServletRequest request){
		return Long.parseLong(request.getSession().getAttribute("rolID").toString());
	}
}
