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

    //Probar que al guardar 2CV los busco y encuentro. QUe al buscar cv por atributo lo encuentro.
    @Test
    @Rollback
    @Transactional
    public void retornaNuloCuandoBuscaPorIdYNoLoEncuentra(){
        long id = 1;
        PerfilProfesional perfilProfesional = repositorioPerfilProfesional.buscarCV(id);
        assertThat(perfilProfesional).isNull();
    }

/*
    @Test
    @Rollback
    @Transactional
    public void buscarCVPorIDDebeDevolverSoloEseCVConEseID(){
        givenExisteCV( 1);
        long id = 1;
        PerfilProfesional perfilEncontrado = whenBuscoPerfilProfesionalPorId(id);
        thenEncuentro(perfilEncontrado,1);
    }
*/
    @Test
    @Rollback
    @Transactional
    public void buscarTodosLosPerfilesProfesionales(){
        givenExisteCV(2);
        List <PerfilProfesional> perfilesProfesionales = whenBuscoTodosLosPerfilesProfesionales();
        thenEncuentroLista(perfilesProfesionales, 2);
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

    private List<PerfilProfesional> whenBuscoTodosLosPerfilesProfesionales(){
        return repositorioPerfilProfesional.buscarTodos();
    }

    private void thenEncuentro(PerfilProfesional perfilProfesional, int idPerfil) {
        assertThat(perfilProfesional.getId()).isEqualTo(idPerfil);
    }

    private void thenEncuentroLista(List<PerfilProfesional> perfiles, int encontradas ){
        assertThat(perfiles).hasSize(encontradas);
    }



}
