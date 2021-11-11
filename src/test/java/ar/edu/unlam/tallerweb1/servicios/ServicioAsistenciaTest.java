package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.ControladorAsistencias;
import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Zona;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostulacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ServicioAsistenciaTest {
    private RepositorioAsistencia repositorioAsistencia = mock(RepositorioAsistencia.class);
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private RepositorioPostulacion repositorioPostulacion = mock(RepositorioPostulacion.class);

    private ServicioAsistencia servicioAsistencia = new ServicioAsistenciaImpl(repositorioAsistencia, repositorioUsuario, repositorioPostulacion);


    @Test(expected = Exception.class)
    public void SiBuscoUnServicioInexistenteDaError() throws Exception {
        whenCreoUnServicio(obtenerAsistencia());
        servicioAsistencia.buscarAsistenciaPorId(3);
    }

    @Test(expected = Exception.class)
    public void SiUnProfesionalSePostulaDosVecesAlMismoEmpleoDaError() throws Exception {
        whenSePostulaDeNuevoAlMismoEmpleo();
        thenNoSePuedePostularyDaError();
    }

    private void whenSePostulaDeNuevoAlMismoEmpleo() throws Exception{
        when(repositorioPostulacion.verSiElUsuarioYaEstaPostulado(1l, 1l)).thenReturn(true);
    }

    private void thenNoSePuedePostularyDaError() throws Exception {
        DatosPostulacion datosPostulacion = new DatosPostulacion();
        datosPostulacion.setIdAsistencia(1L);
        datosPostulacion.setIdUsuario(1L);
        servicioAsistencia.crearPostulacion(datosPostulacion);
    }

    @Test
    @Transactional
    @Rollback
    public void SiBuscoUnServicioExistenteLoRetorna() throws Exception {
        when(repositorioAsistencia.buscarAsistenciaPorId(1)).thenReturn(new Asistencia());
        Assertions.assertThat(servicioAsistencia.buscarAsistenciaPorId(1)).isOfAnyClassIn(Asistencia.class);
    }

    @Test
    public void debePoderAgregarUnServicio(){
        Asistencia creada = whenCreoUnServicio(obtenerAsistencia());
        thenLaCreacionEsExitosa(creada);
    }

    @Test
    public void debePoderEliminarUnServicio(){
        Asistencia creada = whenCreoUnServicio(obtenerAsistencia());
        eliminarSolicitudDeEmpleo(creada.getId());
        thenLaEliminacionEsExitosa(creada);
    }

    private void thenLaCreacionEsExitosa(Asistencia creada){
        Assertions.assertThat(creada).isNotNull();
        Assertions.assertThat(creada.getNombre()).isEqualTo(obtenerAsistencia().getNombre());
        verify(repositorioAsistencia, times(1)).guardar(any());
    }

    private void thenLaEliminacionEsExitosa(Asistencia creada) {
        Assertions.assertThat(creada.getId()).isNull();
        verify(repositorioAsistencia, times(1)).guardar(any());
    }

    private void eliminarSolicitudDeEmpleo(Long id) {
        servicioAsistencia.eliminarSolicitudDeEmpleo(id);
    }

    private Asistencia whenCreoUnServicio(DatosAsistencia datos) {
        return servicioAsistencia.crearServicio(datos);
    }

    private  DatosAsistencia obtenerAsistencia(){
        DatosAsistencia datosAsistencia = new DatosAsistencia();
        datosAsistencia.setNombre("Asistencia");
        datosAsistencia.setIdTurno(1);
        datosAsistencia.setIdFrecuencia(1);
        datosAsistencia.setDescripcion("Se necesita ");
        datosAsistencia.setCamaAdentro(true);
        datosAsistencia.setTarifa(200.0);
        datosAsistencia.setZona(1);

        return datosAsistencia;
    }

    @Test
    public void buscarAsistenciaPorNombreTest() {
        Asistencia asistenciaExpected = new Asistencia("Julieta"
        );
        when(repositorioAsistencia.buscarAsistenciasPorNombre("Julieta")).thenReturn(Collections.singletonList(asistenciaExpected));
        List<Asistencia> asistenciaActuales = servicioAsistencia.buscarAsistenciasPorNombre("Julieta");
        Assertions.assertThat(asistenciaActuales).isNotNull();
        Assertions.assertThat(asistenciaActuales.get(0)).hasFieldOrPropertyWithValue("nombre", "Julieta");
    }

    @Test
    public void buscarAsistenciaPorZonaTest() {
        Asistencia asistenciaExpected = new Asistencia ();
        Zona zona = new Zona();
        zona.setId(1L);
        zona.setNombre("Zona Oeste");
        asistenciaExpected.setZona(zona);
        when(repositorioAsistencia.buscarAsistenciasPorZona(1L)).thenReturn(Collections.singletonList(asistenciaExpected));
        List<Asistencia> asistenciaActuales = servicioAsistencia.buscarAsistenciasPorZona(1L);
        Assertions.assertThat(asistenciaActuales).isNotNull();
        Assertions.assertThat(asistenciaActuales.get(0)).hasFieldOrPropertyWithValue("zona.id",1L);
    }


}