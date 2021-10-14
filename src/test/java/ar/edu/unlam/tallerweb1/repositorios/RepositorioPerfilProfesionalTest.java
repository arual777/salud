package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioPerfilProfesionalTest extends SpringTest {

    @Autowired
    private RepositorioPerfilProfesional repositorioPerfilProfesional;

    @Test
    @Rollback(value = false)
    @Transactional
    public void retornaNuloCuandoBuscaPorIdYNoLoEncuentra(){
        givenExisteCV( 1);
        long id = 2;
        PerfilProfesional perfilProfesional = repositorioPerfilProfesional.buscarCV(id);
        assertThat(perfilProfesional).isNull();
    }

    @Test
    @Rollback(value = false)
    @Transactional
    public void buscarCVPorIDDebeDevolverSoloEseCVConEseID(){
        givenExisteCV( 1);
        long id = 1;
        PerfilProfesional perfilEncontrado = whenBuscoPerfilProfesionalPorId(id);
        thenEncuentro(perfilEncontrado,1);
    }

    private void givenExisteCV(int cantidadDeCV) {
        for(int i = 0; i < cantidadDeCV; i++){
            PerfilProfesional perfilProfesional = new PerfilProfesional();
            perfilProfesional.setFechaNacimiento("2002-06-02");
            perfilProfesional.setEmail("bianca"+i+"@gmail.com");
            perfilProfesional.setExperiencia(i+"blabblbalbalblalbla");
            perfilProfesional.setNombreCompleto(i+"bianca della vecchia");
            perfilProfesional.setNumeroTelefono("112299009"+i);

            session().save(perfilProfesional);
        }
    }

    private PerfilProfesional whenBuscoPerfilProfesionalPorId(Long id) {
        return repositorioPerfilProfesional.buscarCV(id);
    }

    private void thenEncuentro(PerfilProfesional perfilProfesional, int idPerfil) {
        assertThat(perfilProfesional.getId()).isEqualTo(idPerfil);
    }

}
