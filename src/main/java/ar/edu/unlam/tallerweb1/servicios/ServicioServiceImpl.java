package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioService;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service ("servicioService")
@Transactional
public class ServicioServiceImpl implements ServicioService{

    private RepositorioService repositorioService;

    @Autowired
    public ServicioServiceImpl(RepositorioService servicioService){
        this.repositorioService = servicioService;
    }

    @Override
    public Servicio crearServicio(String name) {
        Servicio nuevo = new Servicio();
        nuevo.setName(name);
        repositorioService.guardar(nuevo);
        return nuevo;
    }

    @Override
    public List<Servicio> buscarTodos() {
        //Aca creo que deberia ir la lógica de busqueda de todos los servicios a la DB
        return null;
    }


}
