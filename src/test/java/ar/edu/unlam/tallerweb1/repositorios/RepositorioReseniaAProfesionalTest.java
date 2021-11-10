package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioReseniaAProfesionalTest extends SpringTest {

    @Autowired
    private RepositorioResenia repositorioResenia;
    private ReseniaAProfesional reseniaAProfesional = new ReseniaAProfesional();
    private ReseniaACliente reseniaACliente = new ReseniaACliente();

    @Test
    @Rollback
    @Transactional
    public void queSePuedaRegistrarResenia(){
        givenRegistroResenia(reseniaAProfesional);

        List <ReseniaAProfesional> reseniaAProfesionals = whenBuscoUnaResenia(reseniaAProfesional);

        thenReseniaSeRegistra(reseniaAProfesionals, 1);
    }

    @Test
    @Rollback
    @Transactional
    public void queSePuedaRegistrarReseniaCliente(){
        givenRegistroReseniaACliente(reseniaACliente);

        List <ReseniaACliente> reseniaAClientes = whenBuscoUnaReseniaACliente(reseniaACliente);

        thenReseniaAClienteSeRegistra(reseniaAClientes, 1);
    }



    private void givenRegistroResenia(ReseniaAProfesional reseniaAProfesional) {
        repositorioResenia.guardarResenia(reseniaAProfesional);
    }

    private void givenRegistroReseniaACliente(ReseniaACliente reseniaACliente) {
        repositorioResenia.guardarReseniaACliente(reseniaACliente);
    }

    private List <ReseniaAProfesional> whenBuscoUnaResenia(ReseniaAProfesional reseniaAProfesional){
        return repositorioResenia.buscarReseniaPorId(reseniaAProfesional.getId());
    }

    private List <ReseniaACliente> whenBuscoUnaReseniaACliente(ReseniaACliente reseniaACliente){
        return repositorioResenia.buscarReseniaAClientePorId(reseniaACliente.getId());
    }

    private void thenReseniaSeRegistra(List <ReseniaAProfesional> reseniaAProfesionals, int reseniasTotales){
        assertThat(reseniaAProfesionals).hasSize(reseniasTotales);
    }

    private void thenReseniaAClienteSeRegistra(List <ReseniaACliente> reseniaACliente, int reseniasTotales){
        assertThat(reseniaACliente).hasSize(reseniasTotales);
    }

}
