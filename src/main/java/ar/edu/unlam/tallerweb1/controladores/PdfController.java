package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {
    private ServicioPerfilProfesional servicioPerfilProfesional;

    @Autowired
    public PdfController( ServicioPerfilProfesional servicioPerfilProfesional) {
        this.servicioPerfilProfesional=servicioPerfilProfesional;
    }

    @RequestMapping(value ="/generate/pdf.pdf", method = RequestMethod.GET)
    ModelAndView generatePdf(@RequestParam(value = "bio") Long perfilProfesionalGeneradoId,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        PerfilProfesional perfilProfesional = servicioPerfilProfesional.buscarCV(perfilProfesionalGeneradoId);

        ModelAndView modelAndView = new ModelAndView("pdfView", "command",perfilProfesional);

        return modelAndView;
    }

}