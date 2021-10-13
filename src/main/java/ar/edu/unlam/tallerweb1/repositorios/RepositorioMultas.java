package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Multa;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public abstract class RepositorioMultas {
    public List<Multa> buscarPor(Usuario usuario) {
        return null;
    }

    public abstract List<Multa> buscarPorMail(String mail);
}
