package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPerfilProfesional;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioPerfilProfesionalTest {

    private RepositorioPerfilProfesional repositorioPerfilProfesional = mock(RepositorioPerfilProfesional.class);
    private ServicioPerfilProfesional servicioPerfilProfesional = new ServicioPerfilProfesionalImpl(repositorioPerfilProfesional);

    @Test(expected = Exception.class)
    public void siNoCompletoArrojaError() throws Exception {
        whenNoCompletoForm();
    }

    @Test
    public void siCompletoRegistraPerfil() throws Exception{
       PerfilProfesional perfilCreado = whenCompletoForm();
       assertThat(perfilCreado).isEqualTo(perfilCreado);
    }

    private void whenNoCompletoForm() throws Exception{
        servicioPerfilProfesional.registrarPerfil("s", "s", "s", "s","s", 1, "foto");
    }

    private PerfilProfesional whenCompletoForm() throws Exception{
        return servicioPerfilProfesional.registrarPerfil("Rodrigo", "rodri@gmail.com",
                "Tengo experiencia, creeme xd", "1136008787","2020-10-06", 1, "foto");
    }

}
