package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Multa;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioMultasTest extends SpringTest {

    private final Usuario USUARIO = new Usuario("usuario@com", "123");
    private final Usuario usuario2 = new Usuario("usuario@gmail.com", "123");

    @Autowired
    private RepositorioMultas repositorioMultas;

    @Test @Transactional @Rollback
    public void obtengoLasMultasDeUnUsuarioConInfracciones(){
        List<Multa> multasDelUsuario = new LinkedList<>();

        multasDelUsuario.add(new Multa());
        multasDelUsuario.add(new Multa());

        givenUnUsuarioConMultas(USUARIO, multasDelUsuario);

        List<Multa> multas = whenBuscoLasMultasDelUsuario(USUARIO);

        thenEncuentro(multasDelUsuario.size(), multas);
    }

    @Test @Transactional @Rollback
    public void buscarLasMultasDeUsuarioConGmail(){
        List<Multa> multasDelUsuario = new LinkedList<>();
        multasDelUsuario.add(new Multa());
        multasDelUsuario.add(new Multa());

        givenUnUsuarioConMultas(USUARIO, multasDelUsuario);
        List<Multa> multasDelUsuario2 = new LinkedList<>();
        multasDelUsuario2.add(new Multa());

        givenUnUsuarioConMultas(usuario2, multasDelUsuario2);

        List<Multa> multas = whenBuscoLasMultasDelUsuarioConMail("gmail");

        thenEncuentro(1, multas);
    }

    private List<Multa> whenBuscoLasMultasDelUsuarioConMail(String gmail) {
        return repositorioMultas.buscarPorMail(gmail);
    }

    private List<Multa> whenBuscoLasMultasDelUsuario(Usuario usuario) {
        return repositorioMultas.buscarPor(usuario);
    }

    private void givenUnUsuarioConMultas(Usuario usuario, List<Multa> multasDelUsuario) {
        session().save(usuario);
        for(Multa multa:multasDelUsuario){
            multa.setInfractor(usuario);
            session().save(multa);
        }
    }

    private void thenEncuentro(int cantidadEsperada, List<Multa> multas){
        assertThat(multas).hasSize(cantidadEsperada);
    }


}
