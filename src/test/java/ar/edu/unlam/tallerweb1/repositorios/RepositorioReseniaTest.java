package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioReseniaTest extends SpringTest {

    @Autowired
    private RepositorioResenia repositorioResenia;
    private Resenia resenia = new Resenia();

    @Test
    @Rollback
    @Transactional
    public void queSePuedaRegistrarResenia(){
        givenRegistroResenia(resenia);

        List <Resenia> resenias = whenBuscoUnaResenia(resenia);

        thenReseniaSeRegistra(resenias, 1);
    }

    private void givenRegistroResenia(Resenia resenia) {
        repositorioResenia.guardarResenia(resenia);
    }

    private List <Resenia> whenBuscoUnaResenia(Resenia resenia){
        return repositorioResenia.buscarReseniaPorId(resenia.getId());
    }

    private void thenReseniaSeRegistra(List <Resenia> resenias, int reseniasTotales){
        assertThat(resenias).hasSize(reseniasTotales);
    }

}
