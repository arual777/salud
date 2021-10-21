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

    private static final Long ENFERMERO_ID = 2L;
    private static final String ENFERMERO = "ENFERMERO";

    private static final String ASISTENCIA_CON_NOMBRE = "Juan";
    private static final String CUIDADOR = "Turno noche";
    private static final String ASISTENCIA = "ASISTENCIA";

    @Test
    @Rollback
    @Transactional
    public void creoYBuscoAsistencia(){
        givenUnaNuevaAsistencia();
        List<Asistencia> asistencias = whenCreoYBuscoAsistenciaPorNombre("prueba");
        thenEncuentro(asistencias, 1);
    }

    private void givenUnaNuevaAsistencia() {
        Asistencia asistencia = new Asistencia();
        asistencia.setNombre("prueba");
        repositorioAsistencia.guardar(asistencia);
    }

    private List<Asistencia> whenCreoYBuscoAsistenciaPorNombre(String nombreAsistencia) {
        return repositorioAsistencia.buscarAsistenciaPorNombre(nombreAsistencia);
    }

    private void thenEncuentro (List < Asistencia > asistencias,int asistenciasEncontradas){
        assertThat(asistencias).hasSize(asistenciasEncontradas);
    }

    @Test
    @Rollback
    @Transactional
    public void buscarAsistenciaPorId(){
        givenExisteAsistenciaPorId(ENFERMERO_ID, 2);
        List<Asistencia> asistencias = whenBuscoTodasLasAsistenciasPorId();
        long getASistenciaPorId = asistencias.get(0).getId();
        Asistencia asistenciaPorId = repositorioAsistencia.buscarAsistenciaPorId(getASistenciaPorId);
        assertThat(getASistenciaPorId).isEqualTo(asistencias.get(0).getId());

    }

    private void givenExisteAsistenciaPorId (Long asistenciaNom,int cantAsitencias){
        for (int i = 0; i < cantAsitencias; i++) {
            Asistencia asistencia = new Asistencia();
            asistencia.setId(1L);

            session().save(asistencia);
        }
    }

    private List<Asistencia> whenBuscoTodasLasAsistenciasPorId () {
        return repositorioAsistencia.buscarTodasLasAsistencias();
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
        thenEncuentroTodas(asistencias, 1);
    }

    private void givenExisteAsistencia (String asistenciaNom,int cantAsitencias){
        for (int i = 0; i < cantAsitencias; i++) {
            Asistencia asistencia = new Asistencia();
            asistencia.setNombre(asistenciaNom);

            session().save(asistencia);
        }
    }

    private List<Asistencia> whenBuscoTodasLasAsistencias () {
        return repositorioAsistencia.buscarTodasLasAsistencias();
    }

    private void thenEncuentroTodas (List < Asistencia > asistencias,int asistenciasEncontradas){
        assertThat(asistencias).hasSize(asistenciasEncontradas);
    }

   /*@Test
   @Rollback
   @Transactional
   public void buscarTodasLasAsistenciasTipoTurnoNoche() {
        givenExisteAsistenciaParaTurnoNoche(CUIDADOR, 2);
        List<Asistencia> asistencias = whenBuscoAsistenciaParaLaNoche(CUIDADOR);
        thenEncuentroTodasParaTurnoNoche(asistencias,2);
    }

    private List<Asistencia> whenBuscoAsistenciaParaLaNoche(String cuidador) {
              return repositorioAsistencia.buscarAsistenciaParaLaNoche(cuidador);
    }

    private void givenExisteAsistenciaParaTurnoNoche(String cuidador, int cantAsitenciasPorNoche) {
        for (int i = 0; i < cantAsitenciasPorNoche; i++) {
            Asistencia asistencia = new Asistencia();

            Tipo_Turno tipo_turno = new Tipo_Turno();
            tipo_turno.setFranja(cuidador);

            asistencia.setIdTurno(tipo_turno);

            session().save(asistencia);
        }
    }

    private void thenEncuentroTodasParaTurnoNoche (List < Asistencia > asistencias,int asistenciasEncontradas){
        assertThat(asistencias).hasSize(asistenciasEncontradas);
    }*/

        @Test
        @Rollback
        @Transactional
        public void buscarTodasLasAsistenciasConNombre () {
            givenExisteAsistenciaConNombre(ASISTENCIA_CON_NOMBRE, 0);
            List<Asistencia> asistencias = whenBuscoAsistenciaPorNombre("Juan");
            thenEncuentroAsistenciaConNombre(asistencias, 0);
        }

        private void givenExisteAsistenciaConNombre (String asistenciaNom,int cantAsitencias){
            for (int i = 0; i < cantAsitencias; i++) {
                Asistencia asistencia = new Asistencia();
                asistencia.setNombre(asistenciaNom);

                session().save(asistencia);
            }
        }

        private List<Asistencia> whenBuscoAsistenciaPorNombre(String juan) {
             return repositorioAsistencia.buscarTodasLasAsistencias();
        }

        private void thenEncuentroAsistenciaConNombre (List < Asistencia > asistencias,int asistenciasEncontradas){
            assertThat(asistencias).hasSize(asistenciasEncontradas);
        }

        @Test
        @Rollback
        @Transactional
        public void queSePuedaEditarUnaAsistencia () {
            givenExisteAsistenciaCreada(ASISTENCIA, 1);
            Asistencia modificacion = cuandoQuieroEditarUnaAsistencia(ASISTENCIA);
            entoncesSeModifica(modificacion);
        }

        private void givenExisteAsistenciaCreada (String asistenciaNom,int cantAsitencias){
            for (int i = 0; i < cantAsitencias; i++) {
                Asistencia asistencia = new Asistencia();
                asistencia.setNombre(asistenciaNom);

                session().save(asistencia);
            }
        }

        private Asistencia cuandoQuieroEditarUnaAsistencia (String asistencia){
            List<Asistencia> asistencias = repositorioAsistencia.buscarAsistenciaPorNombre(asistencia);
            return asistencias.get(0);
        }

        private void entoncesSeModifica (Asistencia asistenciaAEditar){
            asistenciaAEditar.setNombre("Cuidados Anuales");
            repositorioAsistencia.guardar(asistenciaAEditar);
            Asistencia asistenciaModificada = repositorioAsistencia.buscarTodasLasAsistencias().get(0);
            assertThat(asistenciaModificada.getNombre()).isEqualTo("Cuidados Anuales");
        }
    }