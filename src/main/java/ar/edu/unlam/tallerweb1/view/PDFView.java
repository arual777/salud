package ar.edu.unlam.tallerweb1.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;


public class PDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model,
                                    Document document, PdfWriter writer, HttpServletRequest req,
                                    HttpServletResponse resp) throws Exception {


        PerfilProfesional perfilProfesional = (PerfilProfesional) model.get("command");
        String titulo = "Bio del profesional: " + perfilProfesional.getNombreCompleto();

        Paragraph header = new Paragraph(new Chunk(titulo, FontFactory.getFont(FontFactory.HELVETICA, 30)));
        Paragraph space = new Paragraph(new Chunk(" "));
        Paragraph email = new Paragraph(new Chunk(" Email: " + perfilProfesional.getEmail(), FontFactory.getFont(FontFactory.HELVETICA, 15)));
        Paragraph fecNac = new Paragraph(new Chunk(" Fecha de nacimiento: " + perfilProfesional.getFechaNacimiento(), FontFactory.getFont(FontFactory.HELVETICA, 15)));
        Paragraph telefono = new Paragraph(new Chunk(" Telefono: " + perfilProfesional.getNumeroTelefono(), FontFactory.getFont(FontFactory.HELVETICA, 15)));
        Paragraph experiencia = new Paragraph(new Chunk(" Experiencia: " + perfilProfesional.getExperiencia(), FontFactory.getFont(FontFactory.HELVETICA, 15)));

        document.add(header);
        document.add(space);
        document.add(space);
        document.add(email);
        document.add(space);
        document.add(fecNac);
        document.add(space);
        document.add(telefono);
        document.add(space);
        document.add(experiencia);

    }
}