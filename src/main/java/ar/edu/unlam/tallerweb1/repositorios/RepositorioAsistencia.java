package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface RepositorioAsistencia {

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciasMensuales();

    List<Asistencia> buscarAsistenciasPorDia();

    List<Asistencia> buscarAsistenciaParaLaNoche();

    void guardar(Asistencia nuevo);

    Object buscar(String name);
}
