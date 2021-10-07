package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Turno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioAsistenciaTest extends SpringTest {

    @Autowired
    private RepositorioAsistencia repositorioAsistencia;

    private static final String ENFERMERO = "ENFERMERO";
    private static final String CUIDADOR = "CUIDADOR";
    private static final String ASISTENCIA = "ASISTENCIA";

    @Test
    @Rollback
    @Transactional
    public void creoYBuscoAsistencia(){
        Asistencia asistencia = new Asistencia();
        asistencia.setNombre("prueba");
        repositorioAsistencia.guardar(asistencia);
        List<Asistencia> asistencias = whenBuscoAsistenciaPorNombre("prueba");
        thenEncuentro(asistencias, 1);
    }

    @Test
    @Rollback
    @Transactional
    public void buscarAsistenciaPorId(){
        givenExisteAsistencia(ENFERMERO, 1);
        List<Asistencia> asistencias = whenBuscoTodasLasAsistencias();
        long c = asistencias.get(0).getId();
        Asistencia asistenciaPorId = repositorioAsistencia.buscarAsistenciaPorId(asistencias.get(0).getId());
        assertThat(asistenciaPorId.getId()).isEqualTo(asistencias.get(0).getId());
    }


    @Test
    @Rollback
    @Transactional
    public void retornaNuloCuandoBuscaPorIdYNoLoEncuentra(){
        Asistencia asistenciaPorId = repositorioAsistencia.buscarAsistenciaPorId(100);
        assertThat(asistenciaPorId).isNull();
    }


    @Test
    @Rollback
    @Transactional
    public void buscarTodasLasAsistencias(){
        givenExisteAsistencia(ENFERMERO, 1);
        List<Asistencia> asistencias = whenBuscoTodasLasAsistencias();
        thenEncuentro(asistencias, 1);
    }

    @Test
    @Rollback
    @Transactional
    public void buscarTodasLasAsistenciasTipoTurnoNoche() {
        givenExisteAsistenciaParaTurnoNoche(CUIDADOR, 2);
        List<Asistencia> asistencias = whenBuscoAsistenciaParaLaNoche();
        thenEncuentro(asistencias,2);
    }

    @Test
    @Rollback
    @Transactional
    public void buscarTodasLasAsistenciasConNombre() {
        givenExisteAsistenciaParaTurnoNoche(CUIDADOR, 3);
        List<Asistencia> asistencias = whenBuscoAsistenciaPorNombre("CUIDA");
        thenEncuentro(asistencias,3);
    }

    @Test
    @Rollback
    @Transactional
    public void queSePuedaEditarUnaAsistencia(){
        givenExisteAsistencia ( ASISTENCIA, 1);
        Asistencia modificacion = cuandoQuieroEditarUnaAsistencia(ASISTENCIA);
        entoncesSeModifica(modificacion);
    }

    private void entoncesSeModifica(Asistencia asistenciaAEditar) {

        asistenciaAEditar.setNombre("Cuidados Anuales");
        repositorioAsistencia.guardar(asistenciaAEditar);
        Asistencia asistenciaModificada = repositorioAsistencia.buscarTodasLasAsistencias().get(0);
        assertThat(asistenciaModificada.getNombre()).isEqualTo("Cuidados Anuales");
    }

    private Asistencia cuandoQuieroEditarUnaAsistencia(String asistencia) {
        List <Asistencia> asistencias = repositorioAsistencia.buscarAsistenciaPorNombre(asistencia);
        return asistencias.get(0);
    }

    private List<Asistencia> whenBuscoAsistenciaParaLaNoche() {
        return repositorioAsistencia.buscarAsistenciaParaLaNoche();
    }

    private List<Asistencia> whenBuscoAsistenciaPorNombre(String nombreAsistencia) {
        return repositorioAsistencia.buscarAsistenciaPorNombre(nombreAsistencia);
    }

    private void givenExisteAsistencia(String asistenciaNom, int cantAsitencias) {
        for(int i = 0; i < cantAsitencias; i++){
            Asistencia asistencia = new Asistencia();
            asistencia.setNombre(asistenciaNom);

            session().save(asistencia);
        }
    }

    private void givenExisteAsistenciaParaTurnoNoche(String asistenciaNom, int cantAsitencias) {
        for(int i = 0; i < cantAsitencias; i++){
            Asistencia asistencia = new Asistencia();
            asistencia.setNombre(asistenciaNom);
            asistencia.setTipo("PorNoche");
            Tipo_Turno tipo_turno = new Tipo_Turno();
            tipo_turno.setFranja("noche");

            asistencia.setIdTurno(tipo_turno);

            session().save(asistencia);
        }
    }

    private void thenEncuentro(List<Asistencia> asistencias, int asistenciasEncontradas) {
        assertThat(asistencias).hasSize(asistenciasEncontradas);
    }

    private List<Asistencia> whenBuscoTodasLasAsistencias() {
        return repositorioAsistencia.buscarTodasLasAsistencias();
    }
}
