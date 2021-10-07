package ar.edu.unlam.tallerweb1.controladores;

public class DatosAsistencia {
    String nombre;
    String tipo;
    long idTurno;

    public long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(long idTurno) { this.idTurno = idTurno; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
