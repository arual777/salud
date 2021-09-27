package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Turno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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


    @Test
    @Rollback @Transactional
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

        thenEncuentro(asistencias,0);
    }

    @Test
    @Rollback
    @Transactional
    public void buscarTodasLasAsistenciasConNombre() {

    }

    private List<Asistencia> whenBuscoAsistenciaParaLaNoche() {
        return repositorioAsistencia.buscarAsistenciaParaLaNoche();
    }

    private void givenExisteAsistenciaParaTurnoNoche() {
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

            Tipo_Turno tipo_turno = new Tipo_Turno();
            tipo_turno.setFranja("noche");
            asistencia.setIdTurno(tipo_turno);

            session().save(asistencia);
        }
    }

    private void thenEncuentro(List<Asistencia> asistencias, int asistenciasEncontradas) {
        //assertThat(asistencias).hasSize(asistenciasEncontradas);
    }

    private List<Asistencia> whenBuscoTodasLasAsistencias() {
        return repositorioAsistencia.buscarTodasLasAsistencias();
    }


}
