package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
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

    @Test
    @Rollback
    @Transactional
    public void queSePuedaRegistrarResenia(){
        givenRegistroResenia(reseniaAProfesional);

        List <ReseniaAProfesional> reseniaAProfesionals = whenBuscoUnaResenia(reseniaAProfesional);

        thenReseniaSeRegistra(reseniaAProfesionals, 1);
    }

    private void givenRegistroResenia(ReseniaAProfesional reseniaAProfesional) {
        repositorioResenia.guardarResenia(reseniaAProfesional);
    }

    private List <ReseniaAProfesional> whenBuscoUnaResenia(ReseniaAProfesional reseniaAProfesional){
        return repositorioResenia.buscarReseniaPorId(reseniaAProfesional.getId());
    }

    private void thenReseniaSeRegistra(List <ReseniaAProfesional> reseniaAProfesionals, int reseniasTotales){
        assertThat(reseniaAProfesionals).hasSize(reseniasTotales);
    }

}
